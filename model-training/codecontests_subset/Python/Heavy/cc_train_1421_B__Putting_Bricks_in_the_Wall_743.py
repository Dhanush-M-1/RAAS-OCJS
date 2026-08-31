for _ in range(int(input())):
    n = int(input())
    l = list()
    for i in range(n):
        l.append(input())
    
    a, b = l[0][1], l[1][0]
    x, y = l[n-1][n-2], l[n-2][n-1]
    
    if a==b and x==y:
        if a!=x:
            print(0)
        else:
            print(2)
            print(1, 2)
            print(2, 1)
    
    elif a == b:
        if a==x and x!=y: 
            print(1)
            print(n, n-1)
        elif a==y and x!=y: 
            print(1)
            print(n-1, n)
        elif a==x and a==y: 
            print(2)
            print(n, n-1)
            print(n-1, n)
    elif x == y:
        if a==x and a!=b: 
            print(1)
            print(1, 2)
        elif b==x and a!=b: 
            print(1)
            print(2, 1)
        elif a==x and a==y: 
            print(2)
            print(n, n-1)
            print(n-1, n)
            
    
    else:
        print(2)
        if a==x:
            print(1, 2)
            print(n-1, n)
        elif a==y:
            print(1, 2)
            print(n, n-1)
    
    