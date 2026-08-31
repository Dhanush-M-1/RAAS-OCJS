a,b=map(int,input().split())
total=0
while a>0:
    total=total+1
    a=a-1
    if total%b==0:
        a=a+1
print(total)     