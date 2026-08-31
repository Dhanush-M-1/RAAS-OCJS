a, b = map(int, input().split())
count, current, extra = 0, a, 0
while current > 0:
    count += current
    current += extra
    extra = current % b
    current = current // b
print (count)
