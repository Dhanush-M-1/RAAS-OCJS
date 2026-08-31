#379A
a,b=map(int,input().split())
num=a
while a >=b:
    num+=a//b
    a=(a%b)+a//b
print(num)
    