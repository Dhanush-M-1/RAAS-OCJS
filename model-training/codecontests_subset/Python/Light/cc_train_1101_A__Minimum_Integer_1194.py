R = lambda: map(int, input().split())
q = int(input())
while q > 0:
    q = q-1
#R = lambda: map(int, input().split())
    l,r,d = R()
    if d < l:
        print(d)
    elif d > r:
        print(d)
    else:
        print(d*((r//d)+1))