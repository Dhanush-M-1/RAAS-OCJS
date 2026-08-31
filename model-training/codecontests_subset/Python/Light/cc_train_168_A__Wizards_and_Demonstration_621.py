n, x, y = map(int, input().split())
real_percentage = (x / n) * 100

needed_clone = 0
while real_percentage < y:
    needed_clone += 1
    x += 1
    real_percentage = (x / n) * 100

print(needed_clone)