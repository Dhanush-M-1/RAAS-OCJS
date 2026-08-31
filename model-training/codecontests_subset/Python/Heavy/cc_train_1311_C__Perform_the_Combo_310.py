from collections import *

for _ in range(int(input())):
    
    n,m = map(int,input().split())
    s = input()
    p = list(map(int,input().split()))
    d = {}
    
    for i in range(26):
        d[i] = [0]
        
    for i in range(n):
        
        o = int(ord(s[i])-97)
        # print(o)
        
        for j in range(26):
            
            if(j == o):
                d[j].append(d[j][-1]+1)
            else:
                d[j].append(d[j][-1])
        
    sn = [0]*26        
    for i in range(m):
        k = p[i]
        # print(k,d[0])
        for j in range(26):
            sn[j] += d[j][k]
    
    for j in range(26):
        sn[j] += d[j][n]
    
    print(*sn)