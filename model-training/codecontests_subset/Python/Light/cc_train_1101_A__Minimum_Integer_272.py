
MOD = 10**9 + 7
I = lambda:list(map(int,input().split()))

t, = I()
while t:
    t -= 1
    l, r, d = I()
    if l <= d <= r:
        if r%d == 0:
            print(r + d)
        else:
            print(r - r%d + d)
    else:
        print(d)