a, b = map(int, input().split())
pr = 0
time = 0
while a > 0:
    time += 1    
    a = a-1
    pr += 1
    if pr == b:
        a += 1
        pr = 0
print(time)