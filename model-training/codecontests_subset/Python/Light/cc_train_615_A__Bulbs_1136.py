num_buttons, num_bulbs = map(int, input().split())
lit = set()
for i in range(num_buttons):
    data = list(map(int, input().split()))
    for x in data[1:]:
        lit.add(x)
if len(lit) == num_bulbs:
    print('YES')
else:
    print('NO')
