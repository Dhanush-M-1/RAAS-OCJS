a,b=map(int,input().split())
result=a
while(a>=b):
    result+=(a//b)
    a=a//b+a%b
print(int(result))