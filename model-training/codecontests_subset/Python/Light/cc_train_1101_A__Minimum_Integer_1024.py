q = int(input())
for i in range(q):
    l,r,d = input().split()
    l = int(l)
    r = int(r)
    d = int(d)
    if d<l or d>r:
        print(d)
    else:
        print((r//d + 1)*d)