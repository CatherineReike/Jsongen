package com.edti.Generators;


import com.edti.Interfaces.IGlobalSerialize;
import com.edti.Interfaces.IUserGenerator;

import com.edti.Models.User;
import com.edti.Shared.GlobalSerialize;
import com.edti.Shared.ParamLoader;
import com.edti.Wrappers.NeptunStudentWrapper;
import com.edti.Wrappers.NeptunTeacherWrapper;

import java.io.IOException;
import java.util.*;

public class UserGenerator implements IUserGenerator {

    Random r = new Random();
    NeptunStudentWrapper neptunStudentWrapper = new NeptunStudentWrapper();
    NeptunTeacherWrapper neptunTeacherWrapper = new NeptunTeacherWrapper();

    public static HashMap<Integer, String> Veznevs;
    static {
        Veznevs = new HashMap<>();
        Veznevs.put(0, "Kovács");
        Veznevs.put(1, "Nemes");
        Veznevs.put(2, "Selmeci");
        Veznevs.put(3, "Nagy");
        Veznevs.put(4, "Tamási");
        Veznevs.put(5, "Kelemen");
        Veznevs.put(6, "Vágner");
    }

    public static HashMap<Integer, String> Kernevs;
    static {
        Kernevs = new HashMap<>();
        Kernevs.put(0, "Imre");
        Kernevs.put(1, "János");
        Kernevs.put(2, "Mátyás");
        Kernevs.put(3, "Dóra");
        Kernevs.put(4, "Anna");
        Kernevs.put(5, "Zorka");
        Kernevs.put(6, "Béla");
    }

    private int numberOfStudents;
    private int doctorpercent;
    private int emailpercent;

    @Override
    public Collection<User> generateUsers() {
        loadExternalParams(ParamLoader.getParams("data.txt"));
        Set<User> creativeUserSet = new HashSet<>();
        int i =0;
        while(i != numberOfStudents)
        {
            String kN = generateKerNev();
            String vN = generateVezNev();
            String nyeptun = generateNeptuneId();
            User currentUser = new User(r.nextInt(10000000), nyeptun, vN, kN, String.format("%s %s", vN, kN), generateEmail(nyeptun));
            if (!creativeUserSet.contains(currentUser)) {
                creativeUserSet.add(currentUser);
                i++;
            }
        }
        return creativeUserSet;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {
        this.numberOfStudents = Integer.parseInt(params.get("numberOfStudents"));
        this.doctorpercent = Integer.parseInt(params.get("doctorpercent"));
        this.emailpercent = Integer.parseInt(params.get("emailpercent"));
    }


    @Override
    public String generateNeptuneId() {

        String betuk = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String neptun ="";
            for (int i = 0; i < 6; i++)
            {
                if (r.nextInt(101)<70)
                {
                    neptun += betuk.charAt(r.nextInt(betuk.length()));
                }
                else
                {
                    neptun += r.nextInt(10);
                }
            }

        return neptun;
    }

    @Override
    public String generateEmail(String nyeptun) {
        if(r.nextInt(101)<emailpercent){
            return null;
        }
        else
            return String.format("%s@mail.com", nyeptun);
    }

    public String generateVezNev(){
        String Nev ="";
        if (r.nextInt(101)<doctorpercent){
            Nev += "dr.";
        }

            Random r = new Random();
            Nev = Veznevs.get(r.nextInt(Veznevs.size()));
            return Nev;

    }
    public String generateKerNev(){
        String Nev ="";
        Random r = new Random();
        Nev = Kernevs.get(r.nextInt(Kernevs.size()));
        return Nev;
    }

    public HashMap<String, ArrayList<User>> GODgenerate() throws IOException {

        Collection<User> users = new HashSet<>(generateUsers());
        ArrayList<User> students = new ArrayList<>();
        ArrayList<User> teachers = new ArrayList<>();
        HashMap<String, ArrayList<User>> vinceEmberkei = new HashMap<>();
        IGlobalSerialize<NeptunStudentWrapper> serializerS = new GlobalSerialize<>();
        IGlobalSerialize<NeptunTeacherWrapper> serializerT = new GlobalSerialize<>();

        int i =1;
        //add to wrappers
        for (User user: users){
            if (i % 3 == 0){
                if (i % 4 ==0){
                    neptunStudentWrapper.getOE_AktivJogviszonyosHallgatokAdat().add(user);
                    students.add(user);

                }
                neptunTeacherWrapper.getOE_AlkalmazottakAdat().add(user);
                teachers.add(user);
            }
            else
                neptunStudentWrapper.getOE_AktivJogviszonyosHallgatokAdat().add(user);
            students.add(user);
            i++;
        }

        vinceEmberkei.put("student", students);
        vinceEmberkei.put("teacher", teachers);

        serializerS.serialize(neptunStudentWrapper, "OE_Get_AktivJogviszonyosHallgatokAdatok");
        serializerT.serialize(neptunTeacherWrapper, "OE_Get_AlkalmazottakAdatok");

        return vinceEmberkei;
                
    }

}
