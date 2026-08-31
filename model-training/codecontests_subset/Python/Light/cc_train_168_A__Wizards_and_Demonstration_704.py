n, x, y = map(int,input().split())
print(max(0,int(n * y // 100 + (n * y % 100 != 0) - x)))
