a, b = map(int, input().split())
print(a * b if max(a, b) < 10 else -1)
