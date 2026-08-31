t = int(input())
while t:
    t -= 1
    n = int(input())
    for i in range(n):
        s = input().strip()
        if i == 0:
            a = int(s[1])
        if i == 1:
            b = int(s[0])
        if i == n-2:
            c = int(s[-1])
        if i == n-1:
            d = int(s[-2])
        else:
            continue
    count = 0
    if a == b:
        if c == a:
            count += 1
        if d == a:
            count += 1
        print(count)
        if c == a:
            print('%d %d'%(n-1, n))
        if d == a:
            print('%d %d'%(n, n-1))
    elif c == d:
        if c == a:
            count += 1
        if c == b:
            count += 1
        print(count)
        if c == a:
            print('%d %d'%(1, 2))
        if c == b:
            print('%d %d'%(2, 1))
    else:
        if a != 0:
            count += 1
        if b != 0:
            count += 1
        if c!= 1:
            count += 1
        if d != 1:
            count += 1
        print(count)
        if a != 0:
            print('%d %d'%(1, 2))
        if b != 0:
            print('%d %d'%(2, 1))
        if c != 1:
            print('%d %d'%(n-1, n))
        if d != 1:
            print('%d %d'%(n, n-1))
