num=input().split()
a=int(num[0])
b=int(num[1])
n=a
while a>=b:
    n+=a//b
    a=a//b+a%b
print(n)
