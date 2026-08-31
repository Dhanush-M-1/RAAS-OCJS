a,b=map(int,input().split())
count=0
count+=a
while a>=b:
    count=count+(a//b)
    a=((a//b)+a%b)
print(count)
