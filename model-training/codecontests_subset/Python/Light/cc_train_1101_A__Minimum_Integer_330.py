q=int(input())
for i in range(q):
    l,r,d=[int(i) for i in input().split()]
    if l>d:
        print(d)
    else:
        print(r+d-(r%d))
        