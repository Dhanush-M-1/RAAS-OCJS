a,b=[int(i) for i in input().split()]
count=0
count+=a
x=a//b
while x!=0:
    count+=x
    a=x+a%b
    x=a//b
print(count)
    