

//dette repositoryet fungerer ikke optimalt//
//kjører ikke//
//inkluderer heller ingen database i obligen av den grunn//

/*
package no.hiof.alexang.oblig5.repository;

import no.hiof.alexang.oblig5.model.Planet;
import no.hiof.alexang.oblig5.model.PlanetSystem;

import java.sql.*;
import java.util.ArrayList;

public class UniverseDBRepository implements IUniversityRepository {

    private Connection connection;

    public UniverseDBRepository(String url, String userName, String password){

        try {
            connection= DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        PlanetSystem planetSystem= new PlanetSystem();
        try{
            String sporring= "SELECT * FROM planetsystem WHERE name=" + planetSystemName;

            Statement statement= connection.createStatement();

            ResultSet resultSet= statement.executeQuery(sporring);

            while(resultSet.next()){
                int id= resultSet.getInt(1);
                String nameS= resultSet.getString(2);
                String pictureUrl= resultSet.getString(3);

                 planetSystem= new PlanetSystem(nameS,pictureUrl);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return planetSystem;
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        ArrayList<PlanetSystem> systemList= new ArrayList<>();
        try{
            String sporring= "SELECT * from planetsystem";

            Statement statement= connection.createStatement();

            ResultSet resultSet= statement.executeQuery(sporring);

            while(resultSet.next()){
                int id= resultSet.getInt(1);
                String name= resultSet.getString(2);
                String pictureUrl= resultSet.getString(3);

                PlanetSystem planetSystem= new PlanetSystem(name,pictureUrl);
                systemList.add(planetSystem);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return systemList;
    }


    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
            return null;
    }


    @Override
    public Planet getPlanet(String planetSystemName, String planet) {
        return null;
    }


    @Override
    public void createPlanet(String planetSystemName, Planet planet) {

    }

    @Override
    public void deletePlanet(String planetSystemName, String planetName) {

    }

    @Override
    public void updatePlanet(String planetSystemName, String planetName, Planet planet) {

    }
}
*/
