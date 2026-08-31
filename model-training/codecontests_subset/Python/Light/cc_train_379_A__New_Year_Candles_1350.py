a,b=[int(x) for x in input().split()]
sum=a
while a//b:
    sum+=a//b
    a-=(a//b)*(b-1)
print(sum)