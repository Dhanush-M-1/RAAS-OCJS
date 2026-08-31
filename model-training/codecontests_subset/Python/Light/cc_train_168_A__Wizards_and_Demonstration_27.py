import math
n , x , y = map(int, input().split())
percentage = math.ceil(y*n/100)
print(max(0, percentage-x))