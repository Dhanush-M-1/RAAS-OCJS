X, Y = map(int, input().split())
ans = X * Y if X <= 9 and Y <= 9 else -1
print(ans)