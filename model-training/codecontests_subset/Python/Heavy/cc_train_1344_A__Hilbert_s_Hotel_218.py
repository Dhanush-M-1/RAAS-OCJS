def main():

    import sys, math
    #from bisect import bisect_left as bl, bisect_right as br, insort
    #from heapq import heapify, heappush, heappop
    from collections import defaultdict as dd, deque
    def data(): return sys.stdin.readline().strip()
    def mdata(): return list(map(int, data().split()))
    out = sys.stdout.write
    # sys.setrecursionlimit(100000)
    INF = int(1e9)
    mod = int(1e9)+7

    for t in range(int(data())):
        n=int(data())
        A=mdata()
        s=set()
        for i in range(n):
            s.add((i+1+A[i])%n)
        if len(s)==n and (min(s)!=1 or max(s)!=n):
            print("YES")
        else:
            print("NO")

if __name__ == '__main__':
    main()
