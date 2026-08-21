class Pair{
    int tweetId;
    int time;
    Pair (int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }
}
class Twitter {
    int time;
    HashMap<Integer, List<Pair>> hm = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> friends = new HashMap<>();
    public Twitter() {
        time = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        //user with userId posted some tweet with tweetId
        // HashMap<Integer, List<Integer>> hm = new HashMap<>();
        //10 recent
        if (!hm.containsKey(userId))
            hm.put(userId, new ArrayList<>());
        hm.get(userId).add(new Pair(tweetId, time));
        time++;
    }
    
    //see the 10 most recent(tweet id is unique.)
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        if (hm.containsKey(userId)){
            for (Pair i : hm.get(userId)){
                pq.add(new Pair(i.tweetId, i.time));
                if (pq.size()>10)
                    pq.remove();
            }
        }

        if (friends.containsKey(userId)){
            for (int i : friends.get(userId)){
                for (Pair j : hm.get(i)){
                    pq.add(new Pair(j.tweetId, j.time));
                    if (pq.size()>10)
                        pq.remove();
                }
            }
        }


        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            ans.add(pq.remove().tweetId);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followedId) {
        if (!friends.containsKey(followerId)){
            friends.put(followerId, new HashSet<>());
        }
        friends.get(followerId).add(followedId);
    }
    
    public void unfollow(int followerId, int followedId) {
        if (friends.containsKey(followerId)){
            friends.get(followerId).remove(followedId);
            if (friends.get(followerId).size() == 0)
                friends.remove(followerId);
        }
    }
}
