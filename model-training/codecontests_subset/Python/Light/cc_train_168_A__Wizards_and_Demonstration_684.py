n, x, y = [int(x) for x in input().split()]
print(max(0, (n * y - 100 * x + 99) // 100))