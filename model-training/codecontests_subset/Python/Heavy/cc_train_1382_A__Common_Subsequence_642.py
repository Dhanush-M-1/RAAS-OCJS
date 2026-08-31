for _ in range(int(input())) :
    n, m = map(int, input().split())
    l1 = list(map(int, input().split()))
    l2 = list(map(int, input().split()))
    if n > m :
        x = l1
        y = l2
    elif n < m :
        x = l2
        y = l1
    else :
        x = l1
        y = l2
    c = 0
    for i in x :
        if c == 1 :
            break            
        elif i in y :
            r = i            
            c += 1
    if c == 1 :
        print('YES')
        print(1, r)
    else :
        print('NO')
        
            
