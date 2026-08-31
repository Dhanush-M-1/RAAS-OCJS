t = int(input())
while t:
    n, v = int(input()), list(map(int, input().split()))
    print("1 2 " + str(n) if v[0]+v[1] <= v[n-1] else -1)
    t -= 1