a=int(input())
b=int(input())
d=abs(a-b)
if d%2==0:
	ans=(d//2)*((d//2)+1)
else:
	ans=(d//2)*((d//2)+1)/2 + (d//2 +1 )*((d//2)+2)/2
print(int(ans))
'''import math
n,a,b=map(int, input().split())
r=int(math.log2(n))
mid0=n
mid1=n//2
for i in range(int(math.log2(n))):
	print (mid1)
	if min(a,b)<=mid1 and max(a,b)>=mid1:
		#print (mid1)
		break
	else:
		r-=1
		mid2=mid1
		if min(a,b)<=mid1 and max(a,b)<=mid1:
			mid1=mid1//2
		else:
			mid1=(mid0+mid1)//2
		mid0=mid2
if r==int(math.log2(n)):
	print("Final!")
else:
	print(r)'''