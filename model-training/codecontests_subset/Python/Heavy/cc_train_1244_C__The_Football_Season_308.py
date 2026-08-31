n,p,w,d=[int(x) for x in input().split(' ')]
ans=-1

def check(mid):
	draw=n-mid
	if draw*d + mid*w >= p:
		return True
	return False

# def check2(mid):
# 	diff=p-w*mid
# 	if diff%d==0:
# 		draws=diff//d
# 		if draws < n-mid:

# 	return False

def gcd(a,b):
	if not b:
		return a
	return gcd(b,a%b)

if p > w*n:
	print(ans)
else:
	low=0
	high=n
	while(low<high):
		mid=(low+high)//2
		if(check(mid)):
			high=mid
		else:
			low=mid+1
	maxWins=p//w
	minWins=mid


	GCD=gcd(w,d)
	if p%GCD:
		print(-1)
	else:
		for x in range(minWins,maxWins+1):
			# print("miwins: ",x,'\n')
			if (p-x*w)%d==0:
				draws=(p-x*w)//d
				loss=n-x-draws
				ans=[x,draws,loss]
				if loss>=0:
					break
		if ans==-1:
			print(-1)
		else:
			print(ans[0],ans[1],ans[2])