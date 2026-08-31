import math
A,B,C = map(int,input().split())
D=B*B-4*A*C
 
if A==0 and B==0 and C==0:
    print(-1)
 
elif A==0 and B==0:
    print(0)    
 
elif A==0:
    x=-C/B
    print(1)
    print('%5.5f'%x)
    
elif D<0:
    print(0)
 
elif D>0:
    print(2)
    x1=(-B+math.sqrt(D))/(2*A)
    x2=(-B-math.sqrt(D))/(2*A)
    if x1 < x2:
        print("%5.5f" % x1)
        print("%5.5f" % x2)
    else:
        print("%5.5f" % x2)
        print("%5.5f" % x1)
    """vyvodx1='%5.5f'%x1
    vyvodx2='%5.5f'%x2"""
  
    """print(vyvodx1)
    print(vyvodx2)"""
    
elif D==0:
    x=-B/(2*A)
    print(1)
    print('%5.5f'%x)
 
