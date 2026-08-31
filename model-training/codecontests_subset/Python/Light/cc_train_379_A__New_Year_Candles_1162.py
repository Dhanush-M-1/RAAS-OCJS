a,b=map(int,input().split())
i=1
c=0
while True:
    if i%b!=0:
        a-=1
    c+=1
    if a==0:
        break
    i+=1
print(c)