r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())

c=((c1-d1)+r2)//2
b=((r1-c1)+d2)//2
a=r1-b
d=d1-a
e={a,b,c,d}
if len(e)==4 and 10>a>0 and 10>b>0 and 10>c>0 and 10>d>0:
    if a+b==r1 and c+d==r2 and a+c==c1 and b+d==c2 and a+d==d1 and b+c==d2:
        
        print(a,b)
        print(c,d)
    else: print(-1)    
else: print(-1)    


"""

a+b=r1    c+d=r2
a+c=c1    b+d=c2
a+d=d1    b+c=d2


b-c=r1-c1   c-b=r2-c2
b+c=d2
2b=(r1-c1)+d2


c-d=c1-d1
c+d=r2
2c=(c1-d1)+r2






"""
