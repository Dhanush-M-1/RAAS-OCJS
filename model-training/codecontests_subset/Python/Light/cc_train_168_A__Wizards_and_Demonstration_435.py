n, x, y = map(int, input().split())
t = 0
while (x+t)/n < y/100:
    t += 1
print(t)

