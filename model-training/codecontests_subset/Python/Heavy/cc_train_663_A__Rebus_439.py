s = input().split(' = ')
n = int(s[1])
t = s[0]
m = len(t) // 4 + 1
val = ['+' for _ in range(m)]
nb = [-1 for _ in range(m)]
for i in range(1, m):
    val[i] = t[4 * i - 2]
mini = 0
maxi = 0
for i in range(m):
    if val[i] == '+':
        mini += 1
        maxi += n
    else:
        mini -= n
        maxi -= 1
    
if not (mini <= n <= maxi):
    print('Impossible')
else:
    v = 0
    for i in range(m):
        if val[i] == '+':
            v += 1
        else:
            v -= 1
        nb[i] = 1
    while v < n:
        for i in range(m):
            if val[i] == '+' and nb[i] == 1:
                nb[i] += min(n - 1, n - v)
                v += nb[i] - 1
    while v > n:
        for i in range(m):
            if val[i] == '-' and nb[i] == 1:
                nb[i] += min(n - 1, v - n)
                v -= nb[i] - 1
    print('Possible')
    s = str(nb[0])
    for i in range(1, m):
        s += ' ' + str(val[i]) + ' ' + str(nb[i])
    s += ' = ' + str(n)
    print(s)