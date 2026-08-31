a = [int(i) for i in input().split()]
sum = 0
sum += a[0]
b = sum
while b != 0:
    if b >= a[1]:
        b -= a[1]
        b += 1
        sum += 1
    else:
        b -= b
print(sum)
