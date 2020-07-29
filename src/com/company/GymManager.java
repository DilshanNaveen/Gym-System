package com.company;

import java.util.List;

public interface GymManager {
    public void addMember(DefaultMember member);
    public boolean deleteMember(String membershipNo);
    public void printListMember();
    public void sort();
    public void save();
    public List<DefaultMember> getMemberList();
    public DefaultMember getMemberByMemberShipNo(String membershipNo);
    public DefaultMember[] getMemberByName(String name);
}
