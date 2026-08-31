#	!/bin/env python3
#	coding: UTF-8


#	✪ H4WK3yE乡
#	Mohd. Farhan Tahir
#	Indian Institute Of Information Technology and Management,Gwalior

#	Question Link
#
#

# ///==========Libraries, Constants and Functions=============///


import sys

inf = float("inf")
mod = 1000000007


def get_array(): return list(map(int, sys.stdin.readline().split()))


def get_ints(): return map(int, sys.stdin.readline().split())


def input(): return sys.stdin.readline()

# ///==========MAIN=============///


def solve():
    dp[0][0] = 1  # 1st tree can be cut to left
    # can be cut to right only if it doesnt covers the second tree
    dp[0][1] = 1 if n > 1 and position[0]+height[0] < position[1] else 0
    dp[0][2] = 1
    for i in range(1, n):
        # not cutting
        dp[i][2] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])

        # cutting to left
        dp[i][0] = dp[i-1][0]

        if position[i]-height[i] > position[i-1]:  # if tree doesnt reaches the previous tree it can be cut to the left
            dp[i][0] = max(dp[i-1][0], dp[i-1][2])+1
            # if cutting tree to left and cutting previous tree to right doesnt
            # touch we can cut previous tree to right
        if position[i]-height[i] > position[i-1]+height[i-1]:
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+1)

        # cutting to right
        if i < n-1 and position[i]+height[i] >= position[i+1]:
            continue
        dp[i][1] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])+1


if __name__ == "__main__":
    n = int(input())
    position = [0]*n
    height = [0]*n
    for i in range(n):
        position[i], height[i] = get_ints()
    dp = [[0]*3 for _ in range(n)]
    # dp[i][0] if ith tree is tried to cut left
    # dp[i][1] if ith three is tried to cut right
    # dp[i][2] if ith tree is not cut
    solve()
    print(max(dp[-1][0], dp[-1][1], dp[-1][2]))
