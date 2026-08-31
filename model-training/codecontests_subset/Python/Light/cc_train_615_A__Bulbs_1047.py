n, m = map(int, input().split())

bulb_list = [item + 1 for item in range(m)]

bulb_compare = []
for i in range(n):
    enter = list(map(int,input().split()))
    y = enter[1:]
    for item in y:
        if item not in bulb_compare:
            bulb_compare.append(item)

if len(bulb_list) == len(bulb_compare):
    print('YES')
else:
    print('NO')
