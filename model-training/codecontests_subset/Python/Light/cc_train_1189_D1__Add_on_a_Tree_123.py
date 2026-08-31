n=int(input())
ar=[0]*n
for i in range(n-1):
	a,b=map(int,input().split())
	ar[a-1]+=1
	ar[b-1]+=1

ans="YES"
for i in range(n):
	if(ar[i]==2):
		ans="NO"
		break
print(ans)