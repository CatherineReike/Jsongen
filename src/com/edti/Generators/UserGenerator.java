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
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserGenerator implements IUserGenerator {


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
    private int numberOfTeachers;
    private int doctorpercent;
    private int emailpercent;
    private int bothpercent;

    @Override
    public Collection<User> generateUsers() {
        loadExternalParams(ParamLoader.getParams("/Users/vasvince/Documents/Munka/Jsongen/data.txt"));
        Set<User> creativeUserSet = new HashSet<>();
        Map<String, User> creativeUserMap = new HashMap<>();
        int i =0;
        while(i != numberOfStudents + numberOfTeachers)
        {
            String kN = generateKerNev();
            String vN = generateVezNev();
            String nyeptun = generateNeptuneId();
            User currentUser = new User(Integer.toString(new Random().nextInt(10000000)), nyeptun, vN, kN, String.format("%s %s", vN, kN), generateEmail(nyeptun));
//            User currentUser = new User(Integer.toString(i), nyeptun, vN, kN, String.format("%s %s", vN, kN), generateEmail(nyeptun));

            if (!creativeUserMap.containsKey(currentUser.getUserID())) {
                creativeUserMap.put(currentUser.getUserID(), currentUser);
                System.out.println("Added to map with id: " + currentUser.getUserID());
                i++;
            } else {
                System.out.println("Vótmá");
            }

            creativeUserMap.forEach((k, v) -> creativeUserSet.add(v));
        }
        return creativeUserSet;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {
        this.numberOfStudents = Integer.parseInt(params.get("numberOfStudents"));
        this.numberOfTeachers = Integer.parseInt(params.get("numberOfTeachers"));
        this.doctorpercent = Integer.parseInt(params.get("doctorpercent"));
        this.emailpercent = Integer.parseInt(params.get("emailpercent"));
        this.bothpercent = Integer.parseInt(params.get("bothpercent"));
    }


    @Override
    public String generateNeptuneId() {

        String betuk = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            StringBuilder neptun = new StringBuilder();
            for (int i = 0; i < 6; i++)
            {
                if (new Random().nextInt(101)<70)
                {
                    neptun.append(betuk.charAt(new Random().nextInt(betuk.length())));
                }
                else
                {
                    neptun.append(new Random().nextInt(10));
                }
            }

        return neptun.toString();
    }

    @Override
    public String generateEmail(String nyeptun) {
        if(new Random().nextInt(101)<emailpercent){
            return "";
        }
        else
            return String.format("%s@mail.com", nyeptun);
    }

    public String generateVezNev(){
        String Nev ="";
        if (new Random().nextInt(101)<doctorpercent){
            Nev += "dr.";
        }

            Random r = new Random();
            Nev += Veznevs.get(r.nextInt(Veznevs.size()));
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

        int i = 0;
        for (User user: users){
            {
                if (i < numberOfTeachers) {
                    Random r = new Random();
                    int percent = r.nextInt(100);
                    if (percent <= bothpercent) {
                        neptunStudentWrapper.getOE_AktivJogviszonyosHallgatokAdat().add(user);
                        students.add(user);
                        i--;
                    }
                    neptunTeacherWrapper.getOE_AlkalmazottakAdat().add(user);
                    teachers.add(user);
                    i++;
                } else {
                    neptunStudentWrapper.getOE_AktivJogviszonyosHallgatokAdat().add(user);
                    students.add(user);
                }
            }
        }

        vinceEmberkei.put("student", students);
        vinceEmberkei.put("teacher", teachers);

        serializerS.serialize(neptunStudentWrapper, "OE_Get_AktivJogviszonyosHallgatokAdatok");
        serializerT.serialize(neptunTeacherWrapper, "OE_Get_AlkalmazottakAdatok");

        return vinceEmberkei;
                
    }

}
