n=int(input())
l=(list(map(int,input().split())))
ans=0
x,y=1,999995+5
ans1=0
ans2=0
for i in l:
    t=abs(x-i)
    t2=abs(y-i)
    if t>=t2:
        if t2>ans1:
            ans1=t2
            
    else:
        if t>ans2:
            ans2=t
        
print(max(ans1,ans2))
    
