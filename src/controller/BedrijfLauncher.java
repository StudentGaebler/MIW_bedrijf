package controller;

import database.AfdelingDAO;
import database.DBaccess;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Laat de werking van mijn bedrijf zien
 */

public class BedrijfLauncher {

    public static void main(String[] args) {
        String dataBase = "bedrijf";
        String mainUser = "userBedrijf";
        String mainUserPassword = "userBedrijfPW";

        DBaccess dBaccess = new DBaccess(dataBase, mainUser, mainUserPassword);
        dBaccess.openConnection();

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);
        System.out.println(afdelingDAO.geefAfdelingen());

        afdelingDAO.slaAfdelingOp(new Afdeling("HR", "Hilversum"));

        ArrayList<Afdeling> mijnAfdelingen = afdelingDAO.geefAfdelingenMetPlaats("Hilversum");
        for (Afdeling afdeling : mijnAfdelingen) {
            System.out.println(afdeling);
        }

        dBaccess.closeConnection();



    }
}
