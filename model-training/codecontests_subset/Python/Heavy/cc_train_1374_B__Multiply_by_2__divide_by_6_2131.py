t = int(input())
for T in range(t):
    n = int(input())
    n1 = n
    count = 0
    if n == 1:
        print(0)
        continue
    if n == 3:
        print(2)
        continue

    
    c3, c2, c6 = 0, 0, 0
    while(n % 3 == 0):
        c3 += 1
        n //= 3
    n = n1
    while(n % 2 == 0):
        c2 += 1
        n //= 2

    
    n = n1
    if c2 > c3:
        print(-1)
        continue
    ans = c3 - c2
    n *= pow(2, ans)
    c6 = 0
    while(n % 6 == 0):
        n //= 6
        c6 += 1
    if n == 1:
        print(ans + c6)
    else:
        print(-1)
