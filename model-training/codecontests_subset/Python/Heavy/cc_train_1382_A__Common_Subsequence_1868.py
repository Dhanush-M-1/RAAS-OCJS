for _ in range(int(input())):
    n,m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = 0
    if n<m:
        for i in a:
            if i in b:
                c = 1
                print('YES')
                print('1 {}'.format(i))
                break
    else:
        for i in b:
            if i in a:
                c = 1
                print('YES')
                print('1 {}'.format(i))
                break
    if c==0:
        print('NO')