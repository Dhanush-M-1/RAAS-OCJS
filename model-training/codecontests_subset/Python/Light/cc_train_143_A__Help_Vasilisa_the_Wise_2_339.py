z=0
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
for x in range(1,10):
    x2=r1-x
    x3=c1-x
    if x3<r2:
        x4=r2-x3
        if x3+x2==d2 and x+x4==d1 and 0<x<10 and 0<x2<10 and 0<x3<10 and 0<x4<10:   
            if  x!=x2 and x3!=x4 and x!=x4 and x3!=x2 and x!=x3 and x2!=x4:
                print('%d %d'%(x,x2))
                print('%d %d'%(x3,x4))
                z+=1
if z==0:
    print(-1)








