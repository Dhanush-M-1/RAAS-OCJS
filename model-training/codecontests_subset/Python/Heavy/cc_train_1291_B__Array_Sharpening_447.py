for _ in range(int(input())):
    n = int(input())
    a = [int(i) for i in input().split()]
    if n == 1:
        print('YES')
    else:
        dlina1, dlina2 = -1, n
        for i in range(n):
            if a[i] >= i:
                dlina1 = i
            else:
                break
        for i in range(n-1, -1, -1):
            if a[i] >= n-1-i:
                dlina2 = i
            else:
                break
        if dlina2<=dlina1:
            print('YES')
        else:
            print('NO')