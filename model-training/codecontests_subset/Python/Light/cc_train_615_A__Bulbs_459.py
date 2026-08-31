a = input().split()
n = int(a[0])
m = int(a[1])
l = [0] * m
for i in range(n):
    str1 = input().split()
    str2 = [int(x) for x in str1]
    for i in str2[1:]:
        l[i - 1] += 1
if 0 in l:
    print('NO')
else:
    print('YES')