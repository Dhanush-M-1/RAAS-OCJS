test = int(input())
for _ in range(test):
    n , l , r = [int(x) for x in input().split()]
    start = 1
    it = 1
    if l == n*(n-1) + 1:
        print('1')
        continue
    while start < l:
        start += (n-it)*2
        it += 1
    if start != l:
        it -= 1
        start -= (n - it)*2
    a = it
    b = it+1
    ok = True
    while start < l:
        if ok:
            ok = False
        else:
            ok = True
            b += 1
        start += 1
    # print(a , b , ok , '--------------------------')
    while start <= r:
        if b == n+1:
            a += 1
            b = a+1
        if a == n:
            # print('------------------')
            print('1' , end=' ')
            break
        if ok:
            print(a , end=' ')
            ok = False
        else:
            print(b , end=' ')
            b += 1
            ok = True
        # ok != ok
        start += 1
    print()

        
