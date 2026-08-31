m, n = [int(i) for i in input().split()]
a = set()
for i in range(m):
    cur = input().split()
    a |= (set(cur[1:]))
if len(a) == n:
    print ('YES')
else:
    print ('NO')