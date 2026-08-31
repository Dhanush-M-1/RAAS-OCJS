for u in range(int(input())):
    s = input()
    k, n, m = map(int, input().split())
    x = [int(w) for w in input().split()]
    y = [int(w) for w in input().split()]
    
    p = False
    i = 0
    j = 0
    z = []
    
    while(i<n or j<m):
        if(i<n and j<m):
            if(x[i] < y[j]):
                z.append(x[i])
                i += 1
                
            else:
                z.append(y[j])
                j += 1
                
        elif(i<n):
            z.append(x[i])
            i += 1
        
        else:
            z.append(y[j])
            j += 1
            
    v = 0
    for i in range(len(z)):
        if(z[i] == 0):
            v += 1
            
        else:
            if(z[i] <= v+k):
                continue
            else:
                p = True
                
    if(p):
        print(-1)
        
    else:
        print(*z)