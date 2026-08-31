temp = [int(x) for x in input().split()]
n = temp[0]
m = temp[1]
checked = [False for x in range(m)]
for i in range(n):
    temp = [int(x) for x in input().split()]
    temp = temp[1:]
    for x in temp:
        checked[x-1] = True
if checked == [True] * m:
    print('YES')
else:
    print('NO')
