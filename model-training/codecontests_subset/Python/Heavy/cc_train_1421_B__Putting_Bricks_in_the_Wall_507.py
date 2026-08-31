t=int(input())
for x in range(t):
    n=int(input())
    grid=[]
    for i in range(n):
        a=input()
        b=[]
        for element in a:
            b.append(element)
        grid.append(b)
    
    relevant=[grid[0][1],grid[1][0],grid[n-1][n-2],grid[n-2][n-1]]
    
    a=[]
    for i in range (1,4):
        
        if relevant[i]==relevant[0]:
            a.append(i)
    
    if len(a)==0:
        print(1)
        print(2, 1)
    elif len(a)==1:
        if int(a[0])<2:
            print(0)
        else:
            if int(a[0])==2:
                print(2)
                print(2, 1)
                print(n, n-1)
            else:
                print(2)
                print(2, 1)
                print(n-1, n)
    elif len(a)==2:
        if 2 in a and 3 in a:
            print(1)
            print(1, 2)
        elif 2 in a:
            print(1)
            print(n, n-1)
        else:
            print(1)
            print(n-1,n)
    else:
        print(2)
        print(1, 2)
        print(2, 1)
            
        
            
            
