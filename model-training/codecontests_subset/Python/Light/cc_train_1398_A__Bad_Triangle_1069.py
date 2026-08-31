for _ in range(int(input())):
    ans = 0
    n = int(input())
    tri = list(map(int, input().split()))
    if tri[0] + tri[1] <= tri[-1]:
        print(1, 2, len(tri))
        ans += 1
    if ans == 0:
        print(-1)