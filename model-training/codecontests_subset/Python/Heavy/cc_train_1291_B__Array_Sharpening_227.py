t = int(input())
for zz in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    b = [False] * (n + 1)
    c = [False] * (n + 1)
    for i in range(n + 1):
        r = (i == 0 or a[i - 1] >= i - 1)
        b[i] = r
        if not r:
            break
        
    for i in range(n + 1):
        r = (i == 0 or a[n - i] >= i - 1)
        c[i] = r
        if not r:
            break

    ha = False
    for i in range(n + 1):
        if ha:
            break
        if i == 0:
            ha = c[-1]
        elif i == n:
            ha = b[-1]
        else:
            ha = b[i] and c[n + 1 - i]
    if ha:
        print('Yes')
    else:
        print('No')

##So we need to sort part of the array.
##Let's walk one by one. For each step say if it is possible.
##Then walk reverse.
##Then find match.
