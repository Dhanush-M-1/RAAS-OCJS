a,b=map(int,input().split())
time=a
while not a<b:
    time+=a//b
    a=a//b+a%b
print(time)