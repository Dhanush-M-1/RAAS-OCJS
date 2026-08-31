n, k = map(int, input().split())

ans = n

while n>=k:
    
    ans += int(n/k)
    n = int(n/k) + int(n%k)
    #print(n)
    
print(int(ans))
        
    
    
    
    
    


