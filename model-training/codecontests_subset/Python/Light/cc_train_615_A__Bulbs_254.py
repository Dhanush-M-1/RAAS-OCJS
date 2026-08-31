a, b = [int(x) for x in input().split()]
bulb = set()
for i in range(a):
    e = input().split()
    bulb.update(set(e[1:]))
print(['NO','YES'][len(bulb) == b])