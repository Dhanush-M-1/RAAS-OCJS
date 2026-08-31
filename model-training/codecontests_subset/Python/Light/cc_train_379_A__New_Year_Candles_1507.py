a,b=map(int,input().split())
hour=a
while(a>=b): hour+=a//b ; a=a//b+a%b
print(hour)