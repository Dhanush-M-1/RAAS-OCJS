a, b = map(int, input().split())

unused, hours = 0, 0

while a:
    hours += a
    a, unused = divmod(a + unused, b)

print(hours)