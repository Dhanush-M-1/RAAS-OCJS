n,m=map(int,input().split())
list1=[]
listk=[]
for i in range(m):
	list1.append(i+1)
for i in range(n):
	listj=list(map(int,input().split()))
	listj.pop(0)
	for j in listj:
		listk.append(j)
set1=set(list1)
set2=set(listk)
if set1==set2:
	print("YES")
else:
	print("NO")