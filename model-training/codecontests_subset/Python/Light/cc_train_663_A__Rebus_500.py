a = ['+'] + input().split()
n, m, s0, s1 = int(a[-1]), len(a) // 2 - 1, 0, 0
for i in range(m):
    if a[2*i] == '+':
        a[2*i+1], s0, s1 = 1, s0+1, s1+n
    else:
        a[2*i+1], s0, s1 = n, s0-n, s1-1
if n not in range(s0, s1+1):
    print('Impossible')
    exit()
for i in range(m):
    d = n - max(1, s0)
    a[2*i+1] += d if a[2*i] == '+' else -d
    s0 += d
print('Possible')
print(' '.join(map(str, a[1:])))
