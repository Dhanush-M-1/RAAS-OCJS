from math import*

for j in range(int(input())):
    n = int(input())
    am2 = 0
    am3 = 0
    n1 = n
    n2 = n
    am = 0
    while n1 % 2 == 0 or n2 % 3 == 0:
        if n1 % 2 == 0:
            am2 += 1
            n1 = n1 // 2
        if n2 % 3 == 0:
            am3 += 1
            n2 = n2 // 3
    k = 2 ** (am3 - am2) * n
    while k % 6 == 0:
        am += 1
        k = k // 6
    if am2 - am3 > 0 or k > 1:
        print(-1)
    else:
        print(int(am3 - am2 + am))
            
                
                                                                      
    
                    
        