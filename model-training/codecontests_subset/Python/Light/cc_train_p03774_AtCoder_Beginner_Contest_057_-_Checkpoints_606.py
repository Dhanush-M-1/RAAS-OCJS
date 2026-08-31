N, M = [int(_) for _ in input().split()]
AB = [[int(_) for _ in input().split()] for _ in range(N)]
C = [[int(_) for _ in input().split()] + [_+1] for _ in range(M)]
for a, b in AB:
    ans = []
    for c in C:
        ans += [[(abs(c[0]-a)+abs(c[1]-b))*100+c[2], c[2]]]
    print(sorted(ans)[0][1])
