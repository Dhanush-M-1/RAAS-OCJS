c=[int(i) for i in input().split(" ")]
a=c[0]
b=c[1]
n=0
while a//b!=0:
    ans=(a//b)
    a=a//b+a%b
    n=n+ans
print(n+c[0])
