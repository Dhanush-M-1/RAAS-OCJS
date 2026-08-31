arr=[]
for i in range(4):
	s=str(input())
	arr1=[]
	for i in s:
		arr1.append(i)
	arr.append(arr1)

for i in range(4):
	for j in range(4):
		if(i<=1 and j<=1):
			countx=0
			countdot=0
			if(arr[i][j]=='x'):
				countx+=1
			elif(arr[i][j]=='.'):
				countdot+=1
			if(arr[i+1][j+1]=='x'):
				countx+=1
			elif(arr[i+1][j+1]=='.'):
				countdot+=1
			if(arr[i+2][j+2]=='x'):
				countx+=1
			elif(arr[i+2][j+2]=='.'):
				countdot+=1
			if(countx==2 and countdot==1):
				print("YES")
				exit(0)
		if(i<=1):
			countx=0
			countdot=0
			if(arr[i][j]=='x'):
				countx+=1
			elif(arr[i][j]=='.'):
				countdot+=1
			if(arr[i+1][j]=='x'):
				countx+=1
			elif(arr[i+1][j]=='.'):
				countdot+=1
			if(arr[i+2][j]=='x'):
				countx+=1
			elif(arr[i+2][j]=='.'):
				countdot+=1
			if(countx==2 and countdot==1):
				print("YES")
				exit(0)
		if(j<=1):
			countx=0
			countdot=0
			if(arr[i][j]=='x'):
				countx+=1
			elif(arr[i][j]=='.'):
				countdot+=1
			if(arr[i][j+1]=='x'):
				countx+=1
			elif(arr[i][j+1]=='.'):
				countdot+=1
			if(arr[i][j+2]=='x'):
				countx+=1
			elif(arr[i][j+2]=='.'):
				countdot+=1
			if(countx==2 and countdot==1):
				print("YES")
				exit(0)
		if(i<=1 and j>=2):
			countx=0
			countdot=0
			if(arr[i][j]=='x'):
				countx+=1
			elif(arr[i][j]=='.'):
				countdot+=1
			if(arr[i+1][j-1]=='x'):
				countx+=1
			elif(arr[i+1][j-1]=='.'):
				countdot+=1
			if(arr[i+2][j-2]=='x'):
				countx+=1
			elif(arr[i+2][j-2]=='.'):
				countdot+=1
			if(countx==2 and countdot==1):
				print("YES")
				exit(0)
print("NO")
