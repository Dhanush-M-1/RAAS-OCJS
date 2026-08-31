
#n = int(input())
n, m = map(int, input().split()) 
#s = input()
a = [0] * m
for j in range(n):
    c = list(map(int, input().split()))
    for i in range(c[0]):
        a[c[i + 1] - 1] = 1
if a.count(0) > 0:
    print('NO')
else:
    print('YES')