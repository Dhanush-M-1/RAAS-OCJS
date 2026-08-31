a, b = map(int, input().split())
print(a * b if max(a, b) <= 9 else -1)