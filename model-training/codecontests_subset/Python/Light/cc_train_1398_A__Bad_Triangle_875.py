t= int(input())
for T in range(t):
    p = 0
    n = int(input())
    l = list(map(int, input().split()))
    s = l[0]+l[1]
    
    for i in range(2, n):
        if l[i]>=s:
            p=i+1
            break
    if p ==0:
        print(-1)
        
    else:
        print("1 2", p)
    
            
        