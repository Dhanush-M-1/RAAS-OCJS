a,b = map(int, input().split())

ans = 0

while a > 0:
    
    if a < b:
        
        ans += a
        
    else:
        
        ans += b
        
    a -= (b-1)
    
print(ans)