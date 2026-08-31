def main():
    from collections import defaultdict
    from heapq import heappop, heappush

    def greedy(L):
        ret = 0
        q = []
        for k, gain in L:
            for g in gain:
                ret += g
                heappush(q, g)
            while len(q) > k:
                g = heappop(q)
                ret -= g
        return ret

    for _ in [0]*int(input()):
        N = int(input())

        ans = 0
        pos = defaultdict(list)
        neg = defaultdict(list)
        for _ in range(N):
            K, L, R = map(int, input().split())
            if L > R:
                ans += R
                pos[K].append(L-R)
            elif L < R:
                ans += L
                neg[N-K].append(R-L)
            else:
                ans += L

        pos = sorted(pos.items())
        neg = sorted(neg.items())
        ans += greedy(pos)
        ans += greedy(neg)

        print(ans)


if __name__ == '__main__':
    main()
