a,b = map(int,input().split())
remain = a
sum = a
while remain >= b:
    temp = remain // b
    sum = sum + temp
    remain = remain - temp * b + temp

print(sum)
    