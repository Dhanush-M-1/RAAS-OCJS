r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
s=r1+r2
a11=(s*2-d2-r2-c2)//2
a12=r1-a11
a22=d1-a11
a21=d2-a12
ss=set([a11,a12,a21,a22])
if len(ss)!=4 or min(ss)<=0 or max(ss)>=10 or not((c1+c2)==s==(d1+d2)):
    print(-1)
else:
    print(a11,a12)
    print(a21,a22)
# Sat Oct 10 2020 22:05:20 GMT+0300 (Москва, стандартное время)
