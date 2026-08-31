n, m = map(int, input().split())
bulb_set = set()
for i in range(n):
    x = [int(j) for j in input().split()]
    del x[0]
    bulb_set.update(x)
print(['NO', 'YES'][len(bulb_set) == m])
