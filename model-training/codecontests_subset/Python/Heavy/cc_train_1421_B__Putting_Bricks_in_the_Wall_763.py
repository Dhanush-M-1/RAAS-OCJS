t = int(input())
for i in range(t):
    n = int(input())
    a1 = 0
    a2 = 0
    a3 = 0
    a4 = 0
    for j in range(n):
        test = list(input())
        if (j == 0):
            a1 = test[1]
        if (j == 1):
            a2 = test[0]
        if (j == n-2):
            a3 = test[-1]
        if (j == n-1):
            a4 = test[-2]
    s = 8*int(a4) + 4*int(a3) + 2*int(a2) + int(a1)
    if(s == 15):
        print(2)
        print(2,1)
        print(1,2)
        
    if(s == 14):
        print(1)
        print(2,1)
        
    if(s == 13):
        print(1)
        print(1,2)
        
    if(s == 12):
        print(0)
    
    if(s == 11):
        print(1)
        print(n,n-1)
        
    if(s == 10):
        print(2)
        print(n, n-1)
        print(1, 2)
        
    if(s == 9):
        print(2)
        print(2,1)
        print(n, n-1)
        
    if(s == 8):
        print(1)
        print(n-1,n)
        
    if(s == 7):
        print(1)
        print(n-1,n)
        
    if(s == 6):
        print(2)
        print(1,2)
        print(n-1,n)
        
    if(s == 5):
        print(2)
        print(2,1)
        print(n-1,n)
        
    if(s == 4):
        print(1)
        print(n, n-1)
        
    if(s == 3):
        print(0)
        
    if(s == 2):
        print(1)
        print(1,2)
        
    if(s == 1):
        print(1)
        print(2,1)
        
    if(s == 0):
        print(2)
        print(1,2)
        print(2,1)
        