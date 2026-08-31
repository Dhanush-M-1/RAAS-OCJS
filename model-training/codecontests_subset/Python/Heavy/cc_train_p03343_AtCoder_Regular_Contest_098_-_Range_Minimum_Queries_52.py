def main():
    N, K, Q = map(int, input().split())
    A = list(map(int, input().split()))
    ans = float("inf")
    for X in A:
        targets = []
        t = []
        for a in A:
            if a >= X:
                t.append(a)
            else:
                if len(t) >= K:
                    targets += sorted(t)[:len(t)-K+1]
                t = []
        if len(t) >= K:
            targets += sorted(t)[:len(t)-K+1]
        targets.sort()
        if len(targets) >= Q:
            ans = min(targets[Q-1] - targets[0], ans)
    print(ans)


if __name__ == "__main__":
    main()
