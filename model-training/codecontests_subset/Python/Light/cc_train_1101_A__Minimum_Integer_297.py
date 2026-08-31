n=int(input())
for i in range(n):
    l=input().split()
    l,r,d=int(l[0]),int(l[1]),int(l[2])
    if l>d:
        print(d)
    elif r<d:
        print(d)
    else:
        print(r+d-(r%d))

