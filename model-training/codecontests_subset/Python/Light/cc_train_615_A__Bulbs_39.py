s1 = input()
n = int(s1.split()[0])
m = int(s1.split()[1])
d = {}
for i in range(0, n):
    s2 = input()
    xi = int(s2.split()[0])
    for j in range(1, xi+1):
        tmp = int(s2.split()[j])
        d[str(tmp)] = 1
flag = 0
for i in range(1, m+1):
    if str(i) not in d:
        flag = 1
if flag == 0:
    print('YES')
else:
    print('NO')