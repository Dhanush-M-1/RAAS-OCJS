n, m = map(int, input().split(' '))
a = [False] * (m+1)
for i in range(n):
    s = input().split(' ')
    k = int(s[0])
    for j in range(1, k + 1):
        a[int(s[j])] |= True
for i in range(1,m+1):
    if a[i] == False:
        print('NO')
        break
else:
    print('YES')
