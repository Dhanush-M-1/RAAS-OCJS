n,m = [int(x) for x in input().split()]
switch = [False] * (m + 1)
cnt = 0
for loops in range(n):
    button = [int(x) for x in input().split()]
    for bulb in range(1,len(button)):
        if switch[button[bulb]] == False:
            switch[button[bulb]] = True
            cnt += 1
if(cnt == m):
    print('YES')
else:
    print('NO')
