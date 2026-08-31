import math
import sys
for _ in range(int(input())):
    n = int(input())
    c,i = 0,0
    k = True
    if n == 2 or n%5 == 0 or n%7 == 0 :
        print(-1)
    elif n == 1:
        print(0)

    else:
        
    
        while n > 1:
            if n % 6 == 0:
                n = n//6
                c += 1
            elif n % 3 == 0:
                n = n//3
                c += 2
            else:
                print(-1)
                k = False
                break

        if k:    
            print(c)
    
