N,M = map(int,input().split())
AB = [tuple(map(int,input().split())) for i in range(N)]
CD = [tuple(map(int,input().split())) for i in range(M)]

for a,b in AB:
    x = z = 10**9
    for i,(c,d) in enumerate(CD):
        dist = abs(a-c) + abs(b-d)
        if dist < x:
            x = dist
            z = i+1
    print(z)