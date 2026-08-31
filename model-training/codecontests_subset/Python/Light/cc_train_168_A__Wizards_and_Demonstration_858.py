a, b, c = map(int, input().split())
a = (c * a + 99) // 100
print(0 if a - b < 0 else a - b)