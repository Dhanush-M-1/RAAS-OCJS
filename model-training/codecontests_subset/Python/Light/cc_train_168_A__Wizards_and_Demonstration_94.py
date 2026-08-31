a, b, c = map(int, input().split())

temp = a * (c / 100)

if temp - int(temp) > 0.0:
    temp = int(temp + 1)
else:
    temp = int(temp)

print(max(0, temp - b))