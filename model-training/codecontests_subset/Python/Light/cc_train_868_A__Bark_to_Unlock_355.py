pas = input()
n = int(input())
s = []
flag1 = False
flag2 = False
flag3 = False
for i in range(n):
    s.append(input())

for i in s:
    if i[1] == pas[0]:
        flag1 = True
    if i[0] == pas[1]:
        flag2 = True
    if i == pas:
        flag3 = True
if flag1 and flag2 or flag3:
    print('YES')
else:
    print('NO')
