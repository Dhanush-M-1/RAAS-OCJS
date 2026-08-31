n = int(input())
a = list(map(int, input().split()))

odd, even = 0, 0
for el in a:
    if el % 2:
        odd += 1
    
    else:
        even += 1

if abs(odd - even) <= 1:
    print(0)
    exit()

a.sort()
ans = 0

if odd > even:
    d = odd - even - 1
    
    for el in a:
        if el % 2:
            ans += el
            d -= 1
        
        if d == 0:
            break
    
    print(ans)

else:
    d = even - odd - 1
    
    for el in a:
        if (el + 1) % 2:
            ans += el
            d -= 1
        
        if d == 0:
            break
    
    print(ans)
