import math

n, x, y = map(int, input().split())

req = math.ceil(y*n/ 100)

deficient = int(req - x)

print(max(0, deficient))

