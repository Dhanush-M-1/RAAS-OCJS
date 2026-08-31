import math
import sys

for i in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    
    d = []
    
    for i in range(n):
        if (a[i] != -1):
            if (i-1 >= 0 and a[i-1] == -1):
                d.append(a[i])
            if (i+1 < n and a[i+1] == -1):
                d.append(a[i])
    
    l = len(d)
    if (l == 0):
        print (0, 1)
    else: 
        
        s = (min(d)+max(d))
        
        k1 = math.floor(s/2)
        k2 = math.ceil(s/2)
        
        m = 0
        
        for i in range(1, n):
            if (a[i] == -1 and a[i-1] == -1):
                m = max(m, 0)
            elif (a[i-1] == -1):
                m = max(m, abs(a[i]-k1))
            elif (a[i] == -1):
                m = max(m, abs(a[i-1]-k1))
            else:
                m = max(m, abs(a[i]-a[i-1]))
                
        m1 = 0
                
        for i in range(1, n):
            if (a[i] == -1 and a[i-1] == -1):
                m1 = max(m1, 0)
            elif (a[i-1] == -1):
                m1 = max(m1, abs(a[i]-k2))
            elif (a[i] == -1):
                m1 = max(m1, abs(a[i-1]-k2))
            else:
                m1 = max(m1, abs(a[i]-a[i-1]))
                
        if (m < m1):
            print(m, k1)
        else:
            print(m1, k2)
    
    
        