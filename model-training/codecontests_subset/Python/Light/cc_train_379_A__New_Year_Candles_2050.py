s = input().split(' ')
a = int(s[0])
b = int(s[1])

count = a

while a >= b:
    a -= b
    a += 1
    count += 1
print(count)