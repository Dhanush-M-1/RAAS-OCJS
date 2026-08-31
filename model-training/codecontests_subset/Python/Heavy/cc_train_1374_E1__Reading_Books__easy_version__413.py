n, k = map(int, input().split())
a = []
b = []
both = []
for i in range(n):
    t, x, y = map(int, input().split())
    if x == 1 and y == 1:
        both.append(t)
    elif x == 1:
        a.append(t)
    elif y == 1:
        b.append(t)
a.sort()
b.sort()
both.sort()

x = len(a)
if len(b)<len(a):
    x = len(b)
if x > k:
    x = k
min = 0
for i in range(0, x):
    min+=a[i]
    min+=b[i]
possible = True
if k-x>len(both):
    print(-1)
    possible = False
if possible == True:
    for j in range(0, k-x):
        min+=both[j]
    if k == x:
        j = -1
    j+=1
    if x == 0:
        i = -1
    sum = min
    while True:
        if i == -1 or j == len(both):
            break
        sum+=both[j]
        sum-=a[i]
        sum-=b[i]
        if sum<min:
            min = sum
        i-=1
        j+=1
    print(min)

