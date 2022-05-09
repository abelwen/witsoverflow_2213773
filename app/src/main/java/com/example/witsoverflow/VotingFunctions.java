package com.example.witsoverflow;      //////sends and gets votes, to be used in any class that instantiates this class
                                       //one of the functions in here increments the num of votes, up or down
public class VotingFunctions {     
    public int upVotes;
    public int dnVotes;

    public VotingFunctions(int upVotes, int dnVotes) {  //constructor
        this.upVotes = upVotes;
        this.dnVotes = dnVotes;
    }

    public int getUpVotes() {   //returns the up vote
        return upVotes;
    }

    public void setUpVotes(int upVotes) {   //sets the up vote  
        this.upVotes = upVotes;
    }

    public int getDnVotes() {   //returns the down vote
        return dnVotes;
    }

    public void setDnVotes(int dnVotes) {   //sets the down votes
        this.dnVotes = dnVotes;
    }

    public int i_upvotes(){    //increaments the up votes 
        return  upVotes+1;
    }

    public int i_downvotes(){   //increaments the down vote
        return  dnVotes+1;
    }
}
