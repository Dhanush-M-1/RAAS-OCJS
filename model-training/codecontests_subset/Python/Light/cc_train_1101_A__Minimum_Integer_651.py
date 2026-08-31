# author: ankan2526

for t in range(int(input())):
    l,r,d=map(int,input().split())
    if l<=d<=r:
        x=r//d
        if x*d<=r:
            x+=1
        print(d*x)
    else:
        print(d)
