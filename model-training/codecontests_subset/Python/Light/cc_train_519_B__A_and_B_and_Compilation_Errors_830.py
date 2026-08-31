n = int(input())

first = input().split(' ')

second = input().split(' ')

third = input().split(' ')

sum1 = 0

for item in first:
    sum1 += int(item)

sum2 = 0

for item in second:
    sum2 += int(item)

sum3 = 0

for item in third:
    sum3 += int(item)

print(str(sum1-sum2))
print(str(sum2-sum3))