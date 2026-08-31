a, b = map(int, input().split())
result = a
res = a
while res // b != 0:
    mod = res % b
    res //= b
    result += res
    res += mod
print(result)
