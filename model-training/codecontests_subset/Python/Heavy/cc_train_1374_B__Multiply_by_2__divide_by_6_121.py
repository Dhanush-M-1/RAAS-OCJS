t = int(input())
for r in range(t):
    n = int(input())
    c = 0
    if n % 5 == 0:
        c = -1
    elif n == 1:
        c = 0
    elif n % 2 == 0 and n % 3 != 0:
        c = -1
    else:
        for i in range(n):
            if n % 2==0 and n % 3 == 0:
                n = n // 6
                c += 1
            elif n % 3 == 0:
                c += 1
                n = n * 2
            else:
                c = -1
                break
            if n == 1:
                break
    print(c)
