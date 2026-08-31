t = int(input())

for _ in range(t):
    n = int(input())
    a, b, *_, c = map(int, input().split())
    if a + b <= c:
        print(1, 2, n)
    else:
        print(-1)
