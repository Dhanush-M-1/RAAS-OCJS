n, x, y = map(int, input().strip().split())

answer  = max(0, - ((-y * n)//100) - x)

print(answer)