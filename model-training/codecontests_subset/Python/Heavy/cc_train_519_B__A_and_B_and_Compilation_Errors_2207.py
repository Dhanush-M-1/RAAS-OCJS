n=int(input())
s=input().split()
t=input().split()
r=input().split()
numbers1=[]
numbers2=[]
numbers3=[]

for i in range(len(s)) :
	numbers1.append(int(s[i]))

for i in range(len(t)) :
	numbers2.append(int(t[i]))

for i in range(len(r)) :
	numbers3.append(int(r[i]))

numbers1.sort()
numbers2.sort()
numbers3.sort()



status1=True
status2=True

for i in range(len(numbers1)-1) :
	if (numbers1[i]!=numbers2[i]) :
		print(numbers1[i])
		status1=False
		break
	if status1==True and i==len(numbers1)-2 :
		print(numbers1[-1])
		break

for i in range(len(numbers2)-1) :
	if (numbers2[i]!=numbers3[i]) :
		print(numbers2[i])
		status1=False
		break
	if status2==True and i==len(numbers2)-2 :
		print(numbers2[-1])
		break