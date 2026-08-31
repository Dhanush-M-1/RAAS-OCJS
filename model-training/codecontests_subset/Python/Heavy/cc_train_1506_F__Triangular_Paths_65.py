import copy

def helper(a, b):
    
    if a == b:
        return 0
    
    x0, y0 = a
    x1, y1 = b
    
    if (x0+y0) % 2 == 0:
        x0 += 1
    y0 += x1-x0
    
    if y1 > y0:
        return x1-x0+1
    elif y1 == y0:
        return 0
    else:
        return (y0-y1+1) // 2

t = int(input())

for i in range(t):
    n = int(input())
    r = list(map(int,input().split()))
    c = list(map(int,input().split()))
    
    pool = [[1,1]]
    for i in range(n):
        pool.append([r[i],c[i]])
    
    pool.sort()
    res = 0
    for i in range(1,n+1):
        res += helper(pool[i-1],pool[i])
    
    print(res)
    
    