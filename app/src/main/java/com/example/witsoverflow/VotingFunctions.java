package com.example.witsoverflow;

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
