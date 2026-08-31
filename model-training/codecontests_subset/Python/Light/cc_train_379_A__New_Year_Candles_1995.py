a,b = map(int, input().split())

rem = 0
hr = 0

while a > 0:
    hr += 1
    a -= 1
    rem += 1
    if rem >= b:
        rem -= b
        a += 1
print(hr)