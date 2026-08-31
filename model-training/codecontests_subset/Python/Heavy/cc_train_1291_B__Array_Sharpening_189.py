import sys

def check(i):

	# mini=n
	# ind=-2
	# for p in range(n):
	# 	if(a[p]==val):
	# 		dist=max(p,n-1-p)
	# 		if(mini>dist):
	# 			mini=dist
	# 			ind=p

	ind=i

	done=1
	prev=a[ind]
	for g in range(ind-1,-1,-1):
		num=min(prev-1,a[g])
		if(num<0):
			done=0
			break
		prev=num

	prev2=a[ind]
	for h in range(ind+1,n):
		num2=min(prev2-1,a[h])
		if(num2<0):
			done=0
			break
		prev2=num2

	if(done==0):
		return "No"
	else:
		return "Yes"

	# if(done==0):
	# 	ans_arr.append("No")
	# else:
	# 	ans_arr.append("Yes")

t=int(sys.stdin.readline())

ans_arr=[]

for x in range(t):
	n=int(sys.stdin.readline())

	a=[int(i) for i in sys.stdin.readline().split()]

	if(n==1):
		ans_arr.append("Yes")
	elif(n==2):
		if(a[0]==0 and a[1]==0):
			ans_arr.append("No")
		else:
			ans_arr.append("Yes")
	else:
		if(n%2==0):
			ans1=check(n//2-1)
			ans2=check(n//2)
			if(ans1=="Yes" or ans2=="Yes"):
				ans_arr.append("Yes")
			else:
				ans_arr.append("No")
		else:
			ans=check(n//2)
			ans_arr.append(ans)
		
print("\n".join(ans_arr))



