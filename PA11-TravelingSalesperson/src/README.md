In order to make my backtrack algorithm more optimized, I did two things. First instead of beginning with an empty trip, I begin with the trip given to us by the heuristic algorithm. This eliminates any recursive case where the current trip would have more cost than this trip. The second is that instead of calling the recursive method then checking if the cost of the new trip is less than the min cost, I check the costs before calling the method again in order to avoid unnecessary recursive calls which take up time. Here are the results of my timing for the three input files that I used for testing (tested on 3 files to make sure my algorithm really was more efficient and wasn't just a fluke for a single file) (each of these times is the average of 100 runs):

big9.mtx
mine = 7 milliseconds
backtrack = 25 milliseconds

big11.mtx
mine = 79 milliseconds
backtrack = 85 milliseconds

big12.mtx
mine = 133 milliseconds
backtrack = 228 milliseconds
