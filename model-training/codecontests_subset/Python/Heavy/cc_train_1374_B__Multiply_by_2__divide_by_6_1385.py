a = int(input())
l = []
for i in range(a):
    n = int(input())
    if n == 1:
        l.append(0)
    elif n == 2:
        l.append(-1)
    elif n == 6:
        l.append(1)
    else:
        c = 0
        p = 0
        d = 0
        while True:
            if n == 2:
                l.append(-1)
                break
            elif n == 3:
                c += 2
                l.append(c)
                break
            elif n==6:
                c+=1
                l.append(c)
                break
            elif n % 6 == 0:
                n = n // 6
                p = 0
                c+=1
            else:
                d = 0
                if p == 1:
                    l.append(-1)
                    d = 1
                else:
                    p = 1
                    n = n * 2
                    c+=1
            if d == 1:
                break
for x in l:
    print(x)

