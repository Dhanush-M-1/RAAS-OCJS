a,b=map(int,input().split())


time=a
for x in range(1001):
    if a//b >=1:
        time+=a//b
        a=a//b+a%b
    if a<1:
        break
print(time)        
