q=int(input())
l=[]
for i in range(q):
    k=input().split()
    l.append(k)
for j in l:
    l=int(j[0])
    r=int(j[1])
    d=int(j[2])
    if d<r:
        if d>=l:
            a=d-(r%d)
            if a==0:
               print(r+d)
            else:
               print(r+a)
        elif l>d:
            print(d)
    elif d>r:
        print(d)
    elif d==r:
        print(2*d)