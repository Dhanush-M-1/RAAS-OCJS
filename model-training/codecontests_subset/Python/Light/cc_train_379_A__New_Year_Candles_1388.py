a, b = map(int, input().split())
sum = 0
c = 0
while (a > 0) or (c >= b):
    sum += a
    c += a
    a, c = c // b, c % b
print(sum)