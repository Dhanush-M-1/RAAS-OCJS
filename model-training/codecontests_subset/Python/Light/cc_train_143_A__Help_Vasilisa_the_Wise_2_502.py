r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
import sys
if (r1+d1-c2)%2==1:
    print(-1)
    sys.exit()
else :
    a=(r1+d1-c2)//2
    b=r1-a
    d=d1-a
    c=r2-d
    l1=[a,b,c,d]
    if a<=0 or b<=0 or c<=0 or d<=0 or a>9 or b>9 or c>9 or d>9 or(a+b)!=r1 or (c+d)!=r2 or (a+d)!=d1 or (b+c)!=d2 or (a+c)!=c1 or (b+d)!=c2:
        print(-1)
        sys.exit()
    if l1.count(l1[0])==1 and l1.count(l1[1])==1 and l1.count(l1[2])==1 and l1.count(l1[3])==1:
        print(a,b)
        print(c,d)
    else :
        print(-1)