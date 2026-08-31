a, b = map(int, input().split())
ans = a * b if a < 10 and b < 10 else -1
print(ans)