import sys
input=sys.stdin.readline
t=int(input())
def bs(l,x,start,end):
	if(start<=end):
		mid=(start+end)//2
		if(l[mid]<x):
			return bs(l,x,mid+1,end)
		else:
			z=bs(l,x,start,mid-1)
			if(z==-1):
				return mid
			else:
				return z



	else:
		return -1





for i in range(t):
	arr=[0]*26


	n,m=map(int,input().split(" "))
	s=input()
	l=list(map(int,input().split(" ")))
	l.sort()
	# print(l)
	for j in range(n):
		x=bs(l,j+1,0,m-1)
		if(x!=-1):
			arr[ord(s[j])-97]+=(m-x)
	for j in range(n):
		arr[ord(s[j])-97]+=1
	s1=""
	for j in arr:
		s1=s1+str(j)+" "
	s1=s1[:-1]
	print(s1)









