t = int(input())
for _ in range(t):
    n = int(input())
    values = list(map(int, input().split()))
    print("-1" if values[0]+values[1]>values[n-1] else f"1 2 {n}")