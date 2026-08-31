n, x, y = (int(x) for x in input().split())
print(max(0, -((100 * x - n * y) // 100)))