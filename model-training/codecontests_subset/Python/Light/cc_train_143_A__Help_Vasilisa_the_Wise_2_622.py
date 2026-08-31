__author__ = 'asmn'
r1,r2=tuple(map(int,input().split()))
c1,c2=tuple(map(int,input().split()))
d1,d2=tuple(map(int,input().split()))

for a11 in range(1,10):
    a12=r1-a11
    a21=c1-a11
    a22=c2-a12
    if a21+a22==r2 and a11+a22==d1 and a12+a21==d2 and 1<=a12<=9 and 1<=a21<=9 and 1<=a22<=9 and a12 !=a11 and a21!=a11 and a21!=a12 and a22 != a11 and a22!=a12 and a22!=a21:
        print('%d %d\n%d %d'%(a11,a12,a21,a22))
        break
else:
    print(-1)