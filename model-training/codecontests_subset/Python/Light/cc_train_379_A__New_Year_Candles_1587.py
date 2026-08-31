a,b=map(int,input().split())
ans,res=0,0
while(a!=0):
    ans+=1
    res+=1
    if res== b:
        res=0
        a+=1
    a-=1
print(ans)