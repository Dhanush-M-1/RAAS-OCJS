a,b = list(map(int, input().split(" ")))
x,sum=a,0
while a>=b:
    sum+=a//b
    a=(a//b)+(a%b)
print(sum+x)