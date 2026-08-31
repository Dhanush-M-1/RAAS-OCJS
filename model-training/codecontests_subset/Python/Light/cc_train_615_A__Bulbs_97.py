buttons, bulbs = map(int, input().split())
all_bulbs = []
for _ in range(buttons):
    array = [int(item) for item in input().split()]
    for bulb in array[1: ]:
        if bulb not in all_bulbs:
            all_bulbs.append(bulb)
if len(all_bulbs) == bulbs:
    print('YES')
else:
    print('NO')