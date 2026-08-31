ab=list(map(int,input().split()))
a=ab[0]
b=ab[1]
count=a
while (a>=b):
    d=a//b
    count+=d
    x=a%b
    a=x+d
print(count)