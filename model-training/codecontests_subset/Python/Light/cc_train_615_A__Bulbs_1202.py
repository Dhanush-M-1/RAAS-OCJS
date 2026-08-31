n, m = list(map(int, input().split()))
flags = [0 for i in range(m)]
for i in range(n):
    bulb_list = list(map(int, input().split()))
    for bulb in bulb_list[1:]:
        flags[bulb-1] = 1
if sum(flags) == m:
    print('YES')
else:
    print('NO')

