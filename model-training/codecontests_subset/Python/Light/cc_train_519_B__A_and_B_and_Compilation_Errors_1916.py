import sys
input=sys.stdin.buffer.readline

n=int(input())
arr=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))
arr.sort()
arr2.sort()
arr3.sort()
c=-1
ans=[]
for i in range(n-1):
	if arr[i]!=arr2[i]:
		ans.append(arr[i])
		c=arr[i]
		break
if c==-1:
	ans.append(arr[-1])
c=-1
arr2.sort()
for i in range(n-2):
	if arr2[i]!=arr3[i]:
		c=arr2[i]
		ans.append(arr2[i])
		break
if c==-1:
	ans.append(arr2[-1])
print(ans[0])
print(ans[1])
