q = int(input())
for i in range(q):
    n = int(input())
    
    cnt = 0
    li = list()
    while n >= 10:
        cnt += 1
        di = 10
        ma = 0
        while di < n:
            l = n % di
            u = n // di
            ma = max(ma, l * u)
            di *= 10
        n = ma
        if ma in li:
            cnt = -1
            break
        li.append(ma)
    print(cnt)
