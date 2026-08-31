A,B,C = map(int,input().split())
import math
D = B * B - 4 * A * C

if A == 0 and B == 0 and C == 0:
    print(-1)

elif A == 0 and B == 0:
    print(0)    

elif A == 0:
    x = - C / B
    print(1)
    print('%4.5f' % x)
    
elif D < 0:
    print(0)

elif D > 0:
    x1 = (- B + math.sqrt(D)) / (2 * A)
    x2 = (- B - math.sqrt(D)) / (2 * A)
    x1, x2 = (x1, x2) if x1 < x2 else (x2, x1)
    
    a = '%4.5f' % x1
    b = '%4.5f' % x2
    print(2)
    print(a)
    print(b)
    
elif D == 0:
    x = - B / (2 * A)
    print(1)
    print('%4.5f' % x)