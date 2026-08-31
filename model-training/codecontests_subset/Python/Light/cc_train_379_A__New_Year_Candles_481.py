a,b = list(map(int,input().split()))
total = a
left = 0
while a > 0:
    total += a//b
    a = a%b+a//b
    if a//b == 0 :
        break
    
print(total)
            
    