t = int(input())
 
for _ in range(t):
    n = int(input())
    r = 1
    p,c = [0]*n,[0]*n
    for i in range(n):
        p[i],c[i] = map(int,input().split())
        
    if(p[0]<c[0]):print("NO")
    else:
        for i in range(1,n):
            dp = p[i] - p[i-1]
            dc = c[i] - c[i-1]
            if(c[i]>p[i]):r = 0
            elif(c[i-1]>c[i]) or (p[i]<p[i-1]):r = 0
            elif(c[i]>c[i-1]) and (dp<dc):r = 0
            
        if(r==0):print("NO")
        else:print("YES")
