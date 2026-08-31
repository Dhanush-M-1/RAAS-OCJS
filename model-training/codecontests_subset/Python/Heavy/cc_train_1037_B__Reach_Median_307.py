from sys import stdin,stdout
def main():
	n,s=map(int,stdin.readline().split( ))
	a=list(map(int,stdin.readline().split( )))
	a.sort()
	mid=(n-1)//2
	if a[mid]==s:
		return 0
	elif a[mid]>s:
		temp=[]
		for i in range(mid):
			if a[i]<=s:
				temp.append(a[i])
			else:
				temp.append(s)
		temp+=[s]+a[mid+1:]
	else:
		temp=[]
		for i in range(mid+1,n):
			if a[i]>=s:
				temp.append(a[i])
			else:
				temp.append(s)
		temp=a[:mid]+[s]+temp
	ans=0
	for i in range(n):
		ans+=abs(a[i]-temp[i])
	return ans
stdout.write("%d"%(main()))