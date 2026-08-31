r1, r2 = map(int, input().split())

c1, c2 = map(int, input().split())

d1, d2 = map(int, input().split())

d = int((d1-(r1-c2))/2)

a = r1+d-c2

b = r1-a

c=c1-a

if ((c+b==d2)&(a+d==d1) &(a+b==r1) &(c+d==r2) &(a+c==c1)&(b+d==c2) &(a!=b) &(a!=c) & (a!=d) & (b!=c) & (b!=d) &(c!=d) &(0<a<=9) &(0<b<=9)&(0<c<=9)&(0<d<=9)):
    print(a,b)
    print(c,d)
else:
    print(-1)

