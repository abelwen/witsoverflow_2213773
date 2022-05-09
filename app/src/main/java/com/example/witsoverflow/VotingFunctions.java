package com.example.witsoverflow;      //////sends and gets votes, to be used in any class that instantiates this class

public class VotingFunctions {     
    public int upVotes;
    public int dnVotes;

    public VotingFunctions(int upVotes, int dnVotes) {
        this.upVotes = upVotes;
        this.dnVotes = dnVotes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDnVotes() {
        return dnVotes;
    }

    public void setDnVotes(int dnVotes) {
        this.dnVotes = dnVotes;
    }

    public int i_upvotes(){
        return  upVotes+1;
    }

    public int i_downvotes(){
        return  dnVotes+1;
    }
}
