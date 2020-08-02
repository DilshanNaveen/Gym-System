package com.company;

import javafx.collections.ObservableList;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface GymManager {
    public void addMember(DefaultMember member);
    public boolean deleteMember(String membershipNo);
    public void printListMember();
    public void sortList();
    public void save();
    public ObservableList<Member> loadTable();
    public ObservableList<Member> searchTableById(int searchId);
    public void loadMemberList();
}
