s = input().split()
a = int(s[0])
b = int(s[1])
count = 0
while a > 0:
    a -= 1
    count += 1
    if count % b == 0:
        a += 1
print(count)
