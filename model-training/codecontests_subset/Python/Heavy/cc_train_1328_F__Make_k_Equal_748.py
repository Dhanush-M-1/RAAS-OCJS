import math
n,m=map(int,input().split())
l=list(map(int,input().split()))
a=sorted(l)
mans=10000000
for k in range(0,n-m+1):
	x=int(math.log(a[k],2))
	for i in range(x+2):
		ans=i
		equal=(a[k]//(2**i))
		count=1
		flag=0
		#print (ans,equal)
		for j in range(k+1,n):
			temp=a[j]
			op=0
			#print (k,count,temp,equal)
			if count==m:
				break
			else:
				while temp>equal:
					temp=temp//2
					op+=1
				if temp==equal:
					count+=1
					ans+=op
			#print (count,equal,ans)
		if count!=m:
			flag=1
		if flag==0:
			if ans<mans:
				mans=ans
	#print (k,ans,flag)
print (mans)


