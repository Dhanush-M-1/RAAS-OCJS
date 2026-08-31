x,y = list(input().strip())
flag = False
f1, f2 = False, False

for _ in range(int(input().strip())):
    i,j = list(input().strip())
    if i == x and y == j:
        flag = True
    if i == y:
        f1 = True
    if j == x:
        f2 = True
if f1 == True and f2 == True:
    flag = True
if flag:
    print('YES')
else:
    print('NO')