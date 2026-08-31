def brute_force_left(a, b):
    best = min(a, b // 2)
    cost = 2 * best + best
    if a < b // 2:
        return cost, b - best * 2
    return cost, 0


def brute_force_right(b, c):
    best = min(b, c // 2)
    cost = 2 * best + best
    if b < c // 2:
        return cost, 0
    return cost, b - c // 2


for i in range(int(input())):
    a, b, c = map(int, input().split(' '))
    cost_0, residue = brute_force_left(a, b)
    cost_1, _ = brute_force_left(residue, c)
    total_left = cost_0 + cost_1
    cost_0, residue = brute_force_right(b, c)
    cost_1, _ = brute_force_right(a, residue)
    total_right = cost_0 + cost_1
    print(max(total_left, total_right))

# 31 85 73
# 0  22 73 -> 31 * 3
# 0  22 73 -> 22 * 3



