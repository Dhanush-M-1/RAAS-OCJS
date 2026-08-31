import math
n = int(input())
a = list(map(int,input().split()))

if n <3:
    if n == 1:
        print(1,1)
        print(-1*a[0])
        print(1,1)
        print(0)
        print(1,1)
        print(0)
    else:
        print(1,1)
        print(-1*a[0])
        print(2,2)
        print(-1*a[1])
        print(1,2)
        print(0,0)
    
else:
    print(1,n-1)
    for i in range(n-1):       
        x = a[i]%n
        a[i] += x*(n-1)
        print(x*(n-1),end= ' ')
    print()

        
        
            
    print(2,n)
    for i in range(1,n):   
        x = a[i]%n
        a[i] += x*(n-1)
        print(x*(n-1),end = ' ')
    print()

    print(1,n)
    for i in range(n):
        print(-1*a[i],end = " ")
    print()
    

        
            
        


