a, b = map(int, input().split())
count = 0
while a:
    count += 1
    a -= 1
    if not count % b:
        a += 1
print(count)