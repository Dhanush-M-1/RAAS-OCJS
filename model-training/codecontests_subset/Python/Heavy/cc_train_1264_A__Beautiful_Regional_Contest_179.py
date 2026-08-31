from collections import Counter
t = int(input())
for _ in range(t):
    n = int(input())
    half = n // 2
    cnt = Counter(map(int, input().split()))
    a = [v for _, v in sorted(cnt.items(), reverse=True)]

    ok, ng = 0, half
    ans = [0, 0, 0]
    while ng - ok > 1:
        mid = (ok + ng) // 2
        count, t = [0, 0, 0], 0
        total = 0
        for v in a:
            if t == 2 and total+v > half:
                break
            count[t] += v
            total += v
            if t == 0 and count[0] >= mid or t == 1 and count[0] < count[t]:
                t += 1

        if min(count) > 0 and count[0] < count[1] and count[0] < count[2] and total <= half:
            ok = mid
            ans = count[:]
        else:
            ng = mid

    print(*ans)