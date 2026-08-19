class Pair{
    int x;
    int y;
    double dist;
    Pair (int x, int y, double dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //you are given a 2d array points where points[i] = [xi, yi]
        //represents the coordinates of a point on x-y axis plane
        //you are also given an integer k.

        //k closest point to the origin (0, 0)
        //the distance between two points is defined as the euclidean
        //distance (sqrt())

        //sbse bda sbse upr rahega
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.dist, a.dist));

        for (int i = 0; i < points.length; i++){
            int x1 = points[i][0], y1 = points[i][1];
            double dist = (double)Math.sqrt(x1 * x1 + y1 * y1);
            pq.add(new Pair(x1, y1, dist));
            if (pq.size() > k)
                pq.remove();
        }

        int ans[][] = new int[pq.size()][2];
        int indx = 0;
        while (!pq.isEmpty()){
            ans[indx][0] = pq.peek().x;
            ans[indx][1] = pq.peek().y;
            pq.remove();
            indx++;
        }

        return ans;
    }
}
