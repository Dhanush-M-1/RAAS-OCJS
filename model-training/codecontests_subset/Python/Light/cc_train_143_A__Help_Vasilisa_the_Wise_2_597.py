r1,r2=[int(x) for x in input().split()]
c1,c2=[int(x) for x in input().split()]
d1,d2=[int(x) for x in input().split()]
a1=(r1+c1-d2)//2
a2=r1-a1
a3=c1-a1
a4=r2-a3
if a1>0 and a2>0 and a3>0 and a4>0 and a1!=a2 and a1!=a3 and a1!=a4 and a2!=a3 and a2!=a4 and a3!=a4 and a1<10 and a2<10 and a3<10 and a4<10:
    if a1+a2==r1 and a1+a3==c1 and a3+a4==r2 and a2+a4==c2 and a1+a4==d1 and a2+a3==d2:
            print(a1,a2)
            print(a3,a4)
    else:
        print('-1')
else:
    print('-1')