t = int(input())
for _ in range(t):
    n = int(input())
    l = [int(x) for x in input().split()]
    
    
    if l[0]+l[1]<=l[-1]:
        print(1,2,n)
        
    else:
        
        print(-1)