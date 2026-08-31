# def checkKey(dict, key): 
# 	if key in dict:
# 		return True
# 	return False
# def helper(s):
# 	l=len(s)
# 	if (l==1):
# 		l=[]
# 		l.append(s)
# 		return l
# 	ch=s[0]
# 	recresult=helper(s[1:])
# 	myresult=[]
# 	myresult.append(ch)
# 	for st in recresult:
# 		myresult.append(st)
# 		ts=ch+st
# 		myresult.append(ts)

# 	return myresult


# mod=1000000000+7
# def helper(s,n,open,close,i):
# 	if(i==2*n):
# 		for i in s:
# 			print(i,end='')
# 		print()
# 		return
# 	if(open<n):
# 		s[i]='('
# 		helper(s,n,open+1,close,i+1)
# 	if(close<open):
# 		s[i]=')'
# 		helper(s,n,open,close+1,i+1)

# def helper(arr,i,n):
# 	if(i==n-1):
# 		recresult=[arr[i]]
# 		return recresult
# 	digit=arr[i]
# 	recresult=helper(arr,i+1,n)
# 	myresult=[]
# 	for i in recresult:
# 		myresult.append(i)
# 		myresult.append(i+digit);
# 	myresult.append(digit)
# 	return myresult
# import copy
# n=int(input())
# arr=list(map(int,input().split()))
# ans=[]
# def helper(arr,i,n):
# 	if(i==n-1):
# 		# for a in arr:
# 		# 	print(a,end=" ")
# 		# print()
# 		l=copy.deepcopy(arr)
# 		ans.append(l)
# 		return
# 	for j in range(i,n):
# 		if(i!=j):
# 			if(arr[i]==arr[j]):
# 				continue
# 			else:
# 				arr[i],arr[j]=arr[j],arr[i]
# 				helper(arr,i+1,n)
# 				arr[j],arr[i]=arr[i],arr[j]
# 		else:
# 			arr[i],arr[j]=arr[j],arr[i]
# 			helper(arr,i+1,n)
# def helper(sol,n,m):
# 	for i in range(n+1):
# 		for j in range(m+1):
# 			print(sol[i][j],end=" ")
# 		print()
# def rat_in_a_maze(maze,sol,i,j,n,m):
# 	if(i==n and j==m):
# 		sol[i][j]=1
# 		helper(sol,n,m)
# 		return True
# 	if(i>n or j>m):
# 		return False
# 	if(maze[i][j]=='X'):
# 		sol[i][j]=0
# 		return False
# 	sol[i][j]=1
# 	if(rat_in_a_maze(maze,sol,i,j+1,n,m)):
# 		sol[i][j]=0
# 		return True
# 	elif(rat_in_a_maze(maze,sol,i+1,j,n,m)):
# 		sol[i][j]=0
# 		return True
# 	else:
# 		sol[i][j]=0
# 		return False



# n,m=map(int,input().split())
# l=[]
# sol=[[0]*m]*n
# for i in range(n):
# 	arr=list(input())
# 	l.append(arr)
# rat_in_a_maze(l,sol,0,0,n-1,m-1)
test=int(input())
for _t in range(test):
	n=int(input())
	arr=list(map(int , input().split()))
	if ((arr[0]+arr[1])<=arr[-1]):
		print(1,end=" ")
		print(2,end=" ")
		print(n)
	else:
		print(-1)


















		




	

















