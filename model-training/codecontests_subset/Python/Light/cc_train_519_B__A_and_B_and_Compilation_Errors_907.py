input()
a = sorted(input().split(" "))
b = sorted(input().split(" "))
c = sorted(input().split(" "))
curr=0
for i in a:
	if curr>=len(b) or i!=b[curr]:
		print(i)
		break
	curr+=1
curr=0
for i in b:
	if curr>=len(c) or i!=c[curr]:
		print(i)
		break
	curr+=1