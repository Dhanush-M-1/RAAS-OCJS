from math import sqrt

x = input()

y = x.split()

a = int(y[0])
b = int(y[1])
c = int(y[2])

det = b**2-4*a*c

if a ==0:
    if b!=0:
       print(1)
       print(-c/b) 
 
    
if b==0:
    if a*c<0:
        print(2)
        print(-sqrt(-c/a))
        print(sqrt(-c/a))

if det <0:
    print(0)

if det ==0:
    if a==0 and b==0 and c==0:
        print (-1)
    elif a==0 and b==0 and c!=0:
        print(0)
    else:    
       print(1)
       print(-b*(2*a)**(-1))
    
if det>0:
    if a!=0:
       print(2)
       X=(-b-sqrt(det))/(2*a)
       Y=(-b+sqrt(det))/(2*a)
       if X>Y:
           print(Y)
           print(X)
       else:
           print(X)
           print(Y)

