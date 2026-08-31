r1,r2 = input().split()
c1,c2 = input().split()
d1,d2 = input().split()
r1,r2,c1,c2,d1,d2 = int(r1),int(r2),int(c1),int(c2),int(d1),int(d2)
 
a1,a2,a3,a4 = r1+d1-c2, r1-d1+c2, 2*d2 - r1 + d1 -c2, c2-r1+d1
 
if a1%2!=0:
    print(-1)
    
elif a1==a2 or a1==a3 or a1==a4 or a2==a3 or a2==a4 or a3==a4:
    print(-1)
elif a1<=0 or a2<=0 or a3<=0 or a4<=0:
    print(-1)
elif a1>=19 or a2>=19 or a3>=19 or a4>=19:
    print(-1)
elif a3+a4 != 2*r2:
    print(-1)
else:
    a1, a2, a3, a4 = a1//2 , a2//2, a3//2, a4//2 
    print(a1 , a2)
    print(a3, a4)