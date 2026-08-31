# x = int(input())
# m, n = map(int, input().split())
# nums = list(map(int, input().split()))
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
b.sort()
def fuck(x):
    c=[]
    for i in range(n):
        c.append((a[i]+x)%m)
    c.sort()
    for i in range(n):
        if(b[i]!=c[i]):
            return 0
    return 1
ans=0x3f3f3f3f
for i in range(n):
    s=((b[0]-a[i])%m+m)%m
    if fuck(s)==1:
        ans=min(ans,s)
print(ans)

 	    	  	   		 	   		    				