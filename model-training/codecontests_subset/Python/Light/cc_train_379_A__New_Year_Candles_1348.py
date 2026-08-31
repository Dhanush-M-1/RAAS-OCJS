a, b = map(int, input().split())
sum = 0
while a != 0:
    if a < b:
        print(sum + a)
        break
    else:
        sum += b
        a = a - b + 1
