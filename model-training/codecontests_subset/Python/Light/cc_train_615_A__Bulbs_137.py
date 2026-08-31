def solve(bulbs):

    for bulb in bulbs:
        if bulb is 0:
            return "NO"

    return "YES"

n,m = map(int, input().split(" "))

bulbs = [0] * m
for _n in range(0, n):
    vals = [int(y) for y in input().split()]
    vals.pop(0)
    for bulbIdx in vals:
        bulbs[bulbIdx-1] = 1

print(solve(bulbs))