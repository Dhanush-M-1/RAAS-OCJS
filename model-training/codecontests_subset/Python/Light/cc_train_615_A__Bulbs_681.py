# A. Bulbs

n, m = map(int, input().split())
bulbs_on = set()
for _ in range(n):
    b = list(map(int, input().split()))
    for x in b[1:]:
        bulbs_on.add(x)
tmp_st = {i for i in range(1, m + 1)}
if bulbs_on == tmp_st:
    print('YES\n')
else:
    print('NO\n')
