n=int(input(''))
arr=list(map(int,input().split()))
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr.sort()
arr1.sort()
arr2.sort()

p=arr
q=arr1
r=arr2
q.append(0)
r.append(0)

for i in range (0,n):
	if p[i]-q[i]!=0:
		print(p[i])
		break
	
for i in range (0,n-1):
	if q[i]-r[i]!=0:
		print(q[i])
		break
	
		
	