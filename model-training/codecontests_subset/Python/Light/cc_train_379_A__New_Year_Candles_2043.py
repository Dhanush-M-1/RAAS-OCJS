a,b=map(int,input().split())
s=a//b
y=a%b
count=a+s
while True:
    if (s+y)//b==0:
        break
    else:
        tmp=s
        s=(s+y)//b
        count+=s
        y=(tmp+y)%b
print(count)