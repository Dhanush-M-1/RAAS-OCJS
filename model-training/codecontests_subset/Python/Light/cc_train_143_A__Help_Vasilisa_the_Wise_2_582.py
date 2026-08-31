r1, r2 = list(map(int, input().split()))
c1, c2 = list(map(int, input().split()))
d1, d2 = list(map(int, input().split()))
x = [0] * 4; y = []; f = True
x[2] = ((c2+d1)-r1) // 2
x[3] = r2 - x[2]
x[1] = c1 - x[3]
x[0] = c2 - x[2]
for i in x:
    if i not in y:
        y.append(i)
for i in x:
    if i < 1 or i > 9:
        f = False
if len(y) != 4 or f is False:
    print(-1)
else:
    print(str(x[1]) + " " + str(x[0]) + '\n' + str(x[3]) + " " + str(x[2]))