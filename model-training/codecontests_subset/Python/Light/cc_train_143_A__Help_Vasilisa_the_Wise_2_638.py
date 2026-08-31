r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
a=(r1+d1-c2)/2
b=(d2+c2-r2)/2
c=c1-a
d=c2-b
x=[a,b,c,d]
if a==int(a) and b==int(b) and c==int(c) and d==int(d) and a+b==r1 and c+d==r2 and x.count(a)==1 and x.count(b)==1 and x.count(c)==1 and x.count(d)==1 and max(x)<=9 and min(x)>=1:
    print(int(a),int(b))
    print(int(c),int(d))
else:
    print(-1)