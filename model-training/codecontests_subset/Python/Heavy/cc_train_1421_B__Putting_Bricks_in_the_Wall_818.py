from sys import stdin


t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    lst = []
    for i in range(n):
        lst.append(stdin.readline())

    d1 = (lst[-1][-4], lst[-2][-3], lst[-3][-2])
    d2 = (lst[-1][-3], lst[-2][-2])

    ans = []

    if d2[0] == d2[1]:
        if d1[0] == d1[1] == d1[2] == d2[0]:
            ans.append((n-1, n))
            ans.append((n, n-1))
        elif d1[0] == d1[1] == d1[2] != d2[0]:
            pass
        else:
            if d1[0] == d2[0]:
                ans.append((n, n-2))
            if d1[1] == d2[0]:
                ans.append((n-1, n-1))
            if d1[2] == d2[0]:
                ans.append((n-2, n))

    elif d1.count('1') > d1.count('0'):
        if d1[0] == '0':
            ans.append((n, n-2))
        if d1[1] == '0':
            ans.append((n-1, n-1))
        if d1[2] == '0':
            ans.append((n-2, n))
        if d2[0] == '1':
            ans.append((n, n-1))
        if d2[1] == '1':
            ans.append((n-1, n))

    else:
        if d1[0] == '1':
            ans.append((n, n-2))
        if d1[1] == '1':
            ans.append((n-1, n-1))
        if d1[2] == '1':
            ans.append((n-2, n))
        if d2[0] == '0':
            ans.append((n, n-1))
        if d2[1] == '0':
            ans.append((n-1, n))
        
    print(len(ans))
    for a in ans:
        print(a[0], a[1])
    
