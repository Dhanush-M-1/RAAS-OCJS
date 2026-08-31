a,b=[int(x) for x in input().split()]
summ = a
while a >= b:
    summ += int(a/b)
    a = int(a/b) + a - b*int(a/b)
print(summ)
