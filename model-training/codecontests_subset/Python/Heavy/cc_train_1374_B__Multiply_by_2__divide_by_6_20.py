t = int(input())
for _ in range(t):
    n = int(input())
    if n == 1:
        print(0)
        continue
    elif n == 3:
        print(2)
        continue
    elif n == 2 or  n== 4 or n == 5:
        print(-1)
        continue
    c =  0
    d = 0    
    while 1:
        if n == 1:
            print(c+d)
            break
        
        if n%6 == 0:
            n //= 6
            c += 1
        else:
            n *= 2
            d += 1
        if d-c > 2:
            print(-1)
            break