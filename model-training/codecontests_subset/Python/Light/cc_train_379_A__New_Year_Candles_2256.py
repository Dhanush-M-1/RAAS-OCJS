a,b=map(int,input().split())
check=True
i=0
while check:
    i+=1
    a-=1
    if i%b==0:
        a+=1
    if a==0:
        check=False
print(i)