r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
c=0
for a in range (1,10):
    for b in range (1,10):
        for x in range (1,10):
            for y in range (1,10):
                if a +b ==r1 and x+y==r2 and a+x== c1 and b+y==c2 and a+y==d1 and b+x==d2 and len(set([a,b,x,y]))==4:
                    print(a,b)
                    print(x,y)
                    c=1
if c==0:
    print(-1)