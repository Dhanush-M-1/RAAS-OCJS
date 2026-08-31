from sys import stdin, stdout
import heapq
from collections import defaultdict
import math
import bisect

def main():
    t = int(stdin.readline())
    for _ in range(t):
        n = int(stdin.readline())
        arr = list(map(int, stdin.readline().split()))
        arr2 = list(map(int, stdin.readline().split()))
        p = []
        for x,y in zip(arr, arr2):
            p.append((x,y))
        p.sort(key=lambda x : x[0])
        P = (1,1)
        dist = 0
        for x,y in p:
            if x == 1:
                continue
            if y - P[1] == x - P[0]:
                if (P[0] + P[1]) % 2 == 0:
                    dist += (x - P[0])
                P = (x,y)
                continue
            if P[0] == 1:
                P = (2,1)
            if (P[0] + P[1]) % 2 == 0:
                P = (P[0] + 1, P[1])
            P = (P[0] + (y - P[1]),y)
            dist += math.ceil((x - P[0]) / 2)
            P = (x,y)
        stdout.write(str(dist)+"\n")

main()