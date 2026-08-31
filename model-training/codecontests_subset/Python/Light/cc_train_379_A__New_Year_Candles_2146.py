m,n=map(int,input().split())
time=m
shengyu=m
while shengyu//n>0:
    time+=shengyu//n
    shengyu=shengyu%n+shengyu//n
print(time)
