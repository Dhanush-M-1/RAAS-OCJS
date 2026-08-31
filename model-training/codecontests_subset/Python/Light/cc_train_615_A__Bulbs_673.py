n,m = map(int,input().split(' '))
bulb = [False]*m
for i in range(n):
    temp = list(map(int,input().split(' ')))[1::]
    for each in temp:
        bulb[each-1] = True
print('YES' if not (False in bulb) else 'NO')