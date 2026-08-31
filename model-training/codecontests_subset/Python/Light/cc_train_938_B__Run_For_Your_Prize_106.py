n=input()
a=list(map(int,input().split()))
lst=[]
for x in a:
	lst.append(min(x-1,10**6-x))
lst.sort()
print(lst[-1])