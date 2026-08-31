array = list(map(int, input().split()))
a, b = array[0], array[1]
counter = 0
while True:
    if a < b:
        counter += a
        break
    else:
        counter += b
        a -= b - 1
print(counter)