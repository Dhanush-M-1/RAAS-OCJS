m,n=map(int,input().split())
a=[False]*(n+1)
a[0]=True
for i in range(m):
    temp=list(map(int,input().split()))
    for kk in temp[1:]:
        a[kk]=True
ans=True
for nn in a:
    ans = nn and ans
if(ans):
    print("YES")
else:
    print("NO")


	 	 		 										   	 						 	