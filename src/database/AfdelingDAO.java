package database;

import model.Afdeling;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 15/11/2021
 * Opslaan en verkrijgen van afdelingen in de database.
 */

public class AfdelingDAO extends AbstractDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO afdeling VALUES (?, ?);";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, afdeling.getAfdelingsnaam());
            preparedStatement.setString(2, afdeling.getAfdelingsplaats());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        String sql = "SELECT * FROM afdeling";
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                String afdelingsPlaats = resultSet.getString("afdelingsplaats");
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return afdelingen;
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String afdelingsPlaats) {
        ArrayList<Afdeling> afdelingenMetPlaats = new ArrayList<>();
        String sql = String.format("SELECT afdelingsnaam FROM afdeling WHERE afdelingsplaats IN ('%s');", afdelingsPlaats);
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString("afdelingsnaam");
                afdelingenMetPlaats.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return afdelingenMetPlaats;
    }
}
