n, m = map(int, input(). split())
list1 = []
for a in range(n):
    list2 = list(input(). split())
    list1.extend(list2[1:])
x = 1
ans = 0
while x <= m:
    if str(x) in list1:
        ans += 1
    x += 1
if ans == m:
    print('YES')
else:
    print('NO')
