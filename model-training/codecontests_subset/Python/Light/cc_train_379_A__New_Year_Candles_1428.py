def candle(a,b):
	if a<b:
		return a
	elif a==b:
		return a+1
	elif a>b:
		ans=a
		rem=a//b
		while ans!=a+rem:
			if (ans+1)%b==0:
				rem+=1
			ans+=1
		return ans

if __name__=="__main__":
	[a,b]=[int(i) for i in input().split(" ")]
	print(candle(a,b))