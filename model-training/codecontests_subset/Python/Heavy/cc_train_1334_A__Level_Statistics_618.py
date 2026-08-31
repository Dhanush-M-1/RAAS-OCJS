T = int(input())
 
for j in range(0, T):
    
    n = int(input())
    p = []
    c = []
    exist = 'YES'
    
    for i in range(0, n):
        
        pi, ci = input().split()
        p.append(int(pi))
        c.append(int(ci))
                
        if p[i] < c[i]:
            exist = 'NO'
        if (i > 0) and (p[i] < p[i - 1]):
            exist = 'NO'
        if (i > 0) and (c[i] < c[i - 1]):
            exist = 'NO'
        if (i > 0) and (p[i] - p[i - 1] < c[i] - c[i - 1]):
            exist = 'NO'
        
    print(exist)