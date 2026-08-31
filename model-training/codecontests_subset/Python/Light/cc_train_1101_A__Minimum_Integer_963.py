q = int(input())

for i in range(q):
    x,l,d = input().split()
    x= int(x)
    l = int(l)
    d = int(d)

    if (d<x or d>l):
        ans = d
    else:
        a = l%d
        b = l+(d-a)
        ans= b
    print(ans)