n=int(input())
l=[]
for i in range(n):
	l.append(list(map(int,input().split())))
count=2
start=l[0][0]
for i in range(1,n-1):
	if l[i][0]-l[i][1]>start:
		count+=1
		start=l[i][0]
	elif l[i][0]+l[i][1]<l[i+1][0]:
		count+=1
		start=l[i][0]+l[i][1]
	else:
		start=l[i][0]
print(min(n,count))