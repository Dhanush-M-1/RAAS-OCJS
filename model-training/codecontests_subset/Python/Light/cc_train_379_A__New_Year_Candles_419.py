a, b = map(int, input().split())
count = a
while a >= b :
    c = a//b
    count += c
    a = a//b + a%b
print(count)
