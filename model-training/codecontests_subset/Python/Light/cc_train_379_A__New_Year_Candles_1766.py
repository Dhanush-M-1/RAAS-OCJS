a, b = map(int, input().split())

result, c = 0, 0

while a:
    result += a
    c += a
    a = c // b
    c %= b

print(result, end="")
