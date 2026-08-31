wo=0;
friend=1000000
t=int(input())
s=input().split(' ')
for i in s:
    x=int(i)
    if(x<=500000):
        if(x>wo):
            wo=x
    else:
        if(x<friend):
            friend=x
ans=wo-1
if(1000000-friend>ans):
    ans=1000000-friend
print(ans)