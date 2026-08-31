n, x, y = map(int, input().split())
left = -1
right = 10000000000
while right - left > 1:
    k = (left + right)//2
    if x + k >= n * (y/100):
        right = k
    else:
        left = k
#print(n * (y/100), x)
print(right)        