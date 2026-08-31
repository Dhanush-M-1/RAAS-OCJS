# maximum of sum subarray

# import math
# a=[-1,2,4,-3,5,2,-5,2]
# summ=0
# best=0

# for i in range(len(a)):
# 	summ=max(a[i],summ+a[i])
# 	best=max(summ,best)
# 	print(best,summ)
# print(best)

#subsets of an array
# def powerSet(index,subset):
# 	global l
# 	if index==n:
		
# 		l.append(subset)
# 		print(subset)
		

# 	else:
		
# 		print("first",index,subset)

# 		powerSet(index+1,subset)
# 		subset.append(strr[index])
# 		powerSet(index+1,subset)
# 		del(subset[len(subset)-1])
		
		
# 		print("second",index,subset)
		

# strr=[1,2,3]
# l=[]
# sub=[]
# ind=0
# n=len(strr)
# powerSet(ind,sub)
# print(l)



# def WaveSorting(arr):
# 	arr.sort()
# 	small =0
# 	large = len(arr)//2
# 	while  small < large and large < len(arr)  :
# 		if arr[small] < arr[large] :
# 		  small+=1
# 		  large+=1
# 		else:
# 		  return "false"
# 	return "true"
# array=[0, 1, 2, 4, 1, 1, 1]
# print(WaveSorting(array))

# def SearchingChallenge(strParam):
#   d={}
#   for i in strParam:
#     if i in d.keys():
#       d[i]+=1
#     else:
#       d[i]=0
#   for i in d.keys():
#     if d[i]==0:
#       return i


# strr="4x + 58 = 100"

# l=list(strr.split(" "))

# def MathChallenge(strParam):
# 	lStr=["+","-",'*',"/"]
# 	lDash=["-","+","/","*"]
# 	l=list(strParam.split(" "))
# 	xInCase=0
# 	xIn=0
# 	for i in [0,2,4]:
# 		if 'x' in l[i]:
# 		  xInCase=i
# 		  for j in range(len(l[i])):
# 		    if l[i][j]=="x":
# 		      xIn = j
# 		      break
# 		  break
# 	strrNew = l[1]+l[2]+"-"+l[4]
# 	for i in range(0,10):
# 		if eval(+str(i)+strrNew) ==0:
# 			print(i)


# n=int(input())
# count=0
# for i in range(n):
# 	temp=input(" ")
# 	if temp=="X++" or temp== "++X":
# 		count+=1
# 	elif temp=="--X" or temp== "X--":
# 		count-=1
# print(count)

# a=input("").lower()
# b=input("").lower()

# flag=True
# for i in range(len(a)):
# 	if a[i]==b[i]:
# 		continue
# 	else:
# 		if ord(a[i])<ord(b[i]):
# 			print("-1")
# 			flag=False
# 			break
# 		else:
# 			print("1")
# 			flag=False
# 			break
# if flag:
# 	print("0")
# l=[]
# p=0
# q=0
# for i in range(5):
# 	temp=input("")
# 	l.append(list(map(int,temp.split(" "))))
# for i in range(len(l)):
# 	for j in range(len(l[i])):
# 		if l[i][j]==1:
# 			p=i
# 			q=j
# 			break
# print(abs(2-p)+abs(2-q))

l=list(map(int,input("").split("+")))
l.sort()
# print(l)
for i in range(len(l)):
	if i==len(l)-1:
		print(str(l[i]))
	else:
		print(str(l[i])+"+",end="")












