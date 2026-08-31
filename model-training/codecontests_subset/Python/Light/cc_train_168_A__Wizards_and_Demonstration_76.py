n, x, y = input().split(" ")
n = int(n)
x = int(x)
y = int(y)

nx = n - x
pp = 0
while ((x + pp)/n) * 100 < y:
    pp += 1
print(pp)
