r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
a=0 ;b=0;c=0;d=0
if (r1+c1-d2)%2==0:
    a = (r1+c1-d2)//2
if (r1+c2-d1)%2==0:
    b = (r1-d1+c2)//2
if (r2+c1-d1)%2==0:
    c = (r2-d1+c1)//2
if (c2+d1-r1)%2==0:
    d = (c2+d1-r1)//2
set1 = {a,b,c,d}
# print(set1)
if 0<a<10 and  0<b<10 and 0<c<10 and 0<d<10 and len(set1)==4 :
    print(a,b)
    print(c,d)
else:
    print(-1)