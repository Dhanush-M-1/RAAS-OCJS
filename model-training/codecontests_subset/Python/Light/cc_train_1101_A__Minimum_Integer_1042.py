q = int(input())
for i in range(q):
    l, r, x = map(int, input().split())
    rr = r%x
    if l > x :
        print(x)
    else:
        rr = x-rr
        print(r+rr)
