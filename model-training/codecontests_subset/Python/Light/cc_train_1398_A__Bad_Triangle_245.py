
# 2200 rating
t=int(input())
for i in range(t):
	n=input()
	l=list(map(int,input().split()))
	# print(l)
	if l[0]+l[1]<=l[-1]:
		print(1,2,n)
	else:
		print(-1)