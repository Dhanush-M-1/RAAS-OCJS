a, b = map(int,input().split())
counter = 0
while a > 0:
    a = a - b + 1
    counter += b
print(counter + a - 1)