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
    public ObservableList<Member> loadTable() throws IOException, ParseException;
    public List<DefaultMember> getMemberList();
    public DefaultMember getMemberByMemberShipNo(String membershipNo);
    public DefaultMember[] getMemberByName(String name);
}
