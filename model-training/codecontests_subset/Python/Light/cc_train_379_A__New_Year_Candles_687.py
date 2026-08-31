a,b=map(int,input().split())
sum=a
if a<b:
    print(sum)
else:
    while a>=b:
        sum=sum+a//b
        a=a//b+a%b
    print(sum)