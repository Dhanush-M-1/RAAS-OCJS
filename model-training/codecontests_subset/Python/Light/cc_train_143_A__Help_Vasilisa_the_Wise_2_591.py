import sys
import math

r1, r2 = [int(x) for x in (sys.stdin.readline()).split()]
c1, c2 = [int(x) for x in (sys.stdin.readline()).split()]
d1, d2 = [int(x) for x in (sys.stdin.readline()).split()]

for i in range(1, 10):
    a1 = i
    a2 = r1 - i
    a3 = c1 - i
    a4 = d1 - i
    
    if(a1 > 0 and a1 < 10 and a2 > 0 and a2 < 10 and a3 > 0 and a3 < 10 and a4 > 0 and a4 < 10 and a1 != a2 and a1 != a3 and a1 != a4 and a2 != a3 and a2 != a4 and a3 != a4 and d2 == a2 + a3 and r2 == a3 + a4 and c2 == a2 + a4):
        print(str(a1) + " " + str(a2))
        print(str(a3) + " " + str(a4))
        exit()
            
print(-1)        
    
