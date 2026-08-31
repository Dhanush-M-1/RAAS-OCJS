a,b=map(int,input().split())
num=a
for i in range(1000):
    if a>=b:
        num+=(a//b)
        a=a//b+a%b
print(num)
