import sys,queue,math,copy,itertools,bisect,collections,heapq

def main():
    sys.setrecursionlimit(10**7)
    INF = 10**18
    MOD = 10**9 + 7
    LI = lambda : [int(x) for x in sys.stdin.readline().split()]
    _LI = lambda : [-int(x) for x in sys.stdin.readline().split()]
    NI = lambda : int(sys.stdin.readline())
    SI = lambda : sys.stdin.readline().rstrip()
    DD = ((1,0),(0,1),(-1,0),(0,-1))

    T = NI()
    for _ in range(T):

        N = NI()
        top = []
        bot = []

        ans = 0
        for _ in range(N):
            k,l,r = LI()
            ans += max(l,r)
            if l < r:
                bot.append((N-k,r-l))
            else:
                top.append((k,l-r))

        top.sort()
        bot.sort()

        q = []
        for k,v in top:
            heapq.heappush(q,v)
            if len(q) > k:
                vd = heapq.heappop(q)
                ans -= vd

        q = []
        for k,v in bot:
            heapq.heappush(q,v)
            if len(q) > k:
                vd = heapq.heappop(q)
                ans -= vd

        print(ans)


if __name__ == '__main__':
    main()