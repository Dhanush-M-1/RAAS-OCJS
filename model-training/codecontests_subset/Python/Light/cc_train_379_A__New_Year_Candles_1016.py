a,b = map(int,input().split())
used = 0
count = 0
while a:
    a -= 1
    used += 1
    count += 1
    if used == b:
        a += 1
        used = 0
print(count)
