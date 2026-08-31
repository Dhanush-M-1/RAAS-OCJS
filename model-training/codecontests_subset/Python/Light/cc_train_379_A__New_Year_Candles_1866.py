a, b = map(int,input().split())
time = a
while a // b != 0:
    time += a // b
    a -= (b - 1) * (a // b)
print(time)