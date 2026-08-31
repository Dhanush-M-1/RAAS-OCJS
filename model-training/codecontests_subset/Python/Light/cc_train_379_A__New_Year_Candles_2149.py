l = [int(x) for x in input().split(' ')]
a = l[0]
b = l[1]

sum1 = a
while(a >= b):
    a = a - b + 1
    sum1 = sum1 + 1
print(sum1)