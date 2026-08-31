n = int(input())

trees = []
heights = []

for i in range (n):
    a, b = [int(i) for i in input().split()]

    trees.append(a)
    heights.append(b)

if n <= 2:
    print(n)

else:

    dp = [[[0, 0] for i in range (2)] for j in range (n)]

    #   L   [left_most, score]
    #   R   []
    #       0   1   2   3   4   5   .   .   .   n

    for i in range (n):
        # print(i)
        
        if i == 0:
            dp[i][0] = [trees[i], 1]
            if trees[i+1]-trees[i] < heights[i]:
                dp[i][1] = [trees[i]+heights[i], 1]

        elif i == n-1:
            dp[i][0] = [trees[i], max(dp[i-1][0][1] + (trees[i]-trees[i-1]>heights[i]) , dp[i-1][1][1] + (trees[i]-dp[i-1][1][0]>heights[i]))]
            dp[i][1] = [trees[i]+heights[i], max(dp[i-1][0][1], dp[i-1][1][1])+1]
            

        else:
            left = dp[i-1][0][0]
            right = dp[i-1][1][0]
            left_score = dp[i-1][0][1]
            right_score = dp[i-1][1][1]

            #LL
            ll = [trees[i], left_score + (trees[i]-left > heights[i])]
            #RL
            rl = [trees[i], right_score + (trees[i]-right > heights[i])]
            #LR
            lr = [trees[i]+heights[i]*(trees[i+1]-trees[i]>heights[i]), left_score + (trees[i+1]-trees[i]>heights[i])]
            #RR
            rr = [trees[i]+heights[i]*(trees[i+1]-trees[i]>heights[i]), right_score + (trees[i+1]-trees[i]>heights[i])]

            if ll[1] == rl[1]:
                dp[i][0] = [min(ll[0], rl[0]), ll[1]]

            else:
                dp[i][0] = ll if (ll[1] > rl[1]) else rl

            if lr[1] == rr[1]:
                dp[i][1] = [min(lr[0], rr[0]), lr[1]]
            
            else:
                dp[i][1] = lr if (lr[1]>rr[1]) else rr

    print(max(dp[n-1][0][1], dp[n-1][1][1]))
        # print(dp)