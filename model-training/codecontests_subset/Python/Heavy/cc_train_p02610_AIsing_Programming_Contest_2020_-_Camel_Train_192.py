def solve():
    N = int(input())

    left = [[] for _ in range(N + 1)]
    right = [[] for _ in range(N + 1)]

    left_len = 0

    s = 0
    for _ in range(N):
        k, l, r = map(int, input().split())
        k -= 1

        mi = min(l, r)
        l -= mi
        r -= mi

        s += mi
        if r:
            k = N - 2 - k
            if k < 0: continue
            right[k].append(r)
        else:
            left[k].append(l)
            left_len += 1

    def additional_happiness(src, len_):
        """src: 二重リスト, 設置可能な位置の制約が厳しい->緩い順の候補リスト
        """
        from heapq import heappop, heappush

        ret = 0

        h = []
        while len(src) > len_:
            cands = src.pop()
            for v in cands:
                heappush(h, -v)

        for cands in reversed(src):
            for v in cands:
                heappush(h, -v)
            if h:
                x = heappop(h)
                ret -= x
        return ret

    s += additional_happiness(left, left_len)
    s += additional_happiness(right, N - left_len)

    return s


def main():
    import sys
    input = sys.stdin.readline

    T = int(input())

    ans = []
    for _ in range(T):
        res = solve()
        ans.append(res)

    print(*ans, sep='\n')


if __name__ == '__main__':
    main()
