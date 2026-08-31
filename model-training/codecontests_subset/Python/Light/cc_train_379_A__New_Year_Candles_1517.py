a, b = map(int, input().split())
temp = 0
hr = 0
while a > 0:
    hr += 1
    a -= 1
    temp += 1
    if temp >= b:
        temp -= b
        a += 1

print(hr)