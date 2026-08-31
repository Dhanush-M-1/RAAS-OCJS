a, b = map(int, input().split())
duration = 0
remains = 0
while a > 0:
    duration += a
    a += remains
    remains = 0
    remains += a % b
    a //= b
print(duration + remains // b)
