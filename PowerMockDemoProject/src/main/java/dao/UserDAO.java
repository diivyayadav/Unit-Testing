package dao;

import domain.User;
import util.IDGenerator;

public class UserDAO {

    public int create(User user){

        int id = IDGenerator.generateID();

        //Here code to save id in db will be written..we are skipping it
        return id;
    }
}
