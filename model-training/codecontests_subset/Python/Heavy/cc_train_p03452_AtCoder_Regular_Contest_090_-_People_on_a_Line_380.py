#!python3

import sys
sys.setrecursionlimit(200000)


# input
N, M = list(map(int, input().split()))
LRD = [tuple(map(int, input().split())) for _ in range(M)]


def judge(W, D, visit, i):
    visit[i] = True
    for j, d in W[i]:
        if D[j] is None:
            D[j] = D[i] + d
        else:
            if D[i] + d != D[j]:
                return True
        if visit[j]:
            continue
        if judge(W, D, visit, j):
            return True
    
    return False


def main():
    W = [[] for _ in range(N)]
    for l, r, d in LRD:
        W[l - 1].append((r - 1, d))
        W[r - 1].append((l - 1, -d))
    
    D = [None] * N
    visit = [False] * N
    for i in range(N):
        if visit[i]:
            continue
        D[i] = 0
        if judge(W, D, visit, i):
            print("No")
            return
    
    print("Yes")


if __name__ == "__main__":
    main()
