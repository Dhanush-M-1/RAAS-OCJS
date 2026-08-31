import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

def getN():
    return int(input())
def getList():
    return list(map(int, input().split()))
import math

def prmatch(ans):
    print("Matching")
    print(*ans)

def solve():
    n, m = getList()
    # print("===================")
    # print(n, m)
    # print("----------------------")
    vertexes = [[] for i in range(3*n)]
    used = [0 for i in range(3*n)]
    ans = []
    lans = 0
    for i in range(m):
        a,b = getList()
        # print(a, b)
        if used[a-1] == 0 and used[b-1] == 0:
            ans.append(i+1)
            lans += 1
            if lans == n:
                prmatch(ans)
                for rem in range(m - i -1):
                    _ = input()
                return
            used[a-1] = 1
            used[b-1] = 1

    indset = []
    for i, u in enumerate(used):
        if u == 0:
            indset.append(i+1)

    print("IndSet")
    # print(ans)
    # print(used)
    print(*indset[:n])
    return



t = getN()
for times in range(t):
    solve()


"""
1
2 15
1 2
1 3
1 4
1 5
1 6
2 3
2 4
2 5
2 6
3 4
3 5
3 6
4 5
4 6
5 6
"""