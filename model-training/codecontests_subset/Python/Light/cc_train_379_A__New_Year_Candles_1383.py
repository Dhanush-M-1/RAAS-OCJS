n,m=tuple(input().split(" "))
n=int(n)
m=int(m)
stock=n
day=0
while stock>0:
    stock-=1
    day+=1
    if day%m==0:
        stock+=1
print(day)