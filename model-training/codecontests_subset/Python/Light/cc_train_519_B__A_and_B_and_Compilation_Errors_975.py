n=int(input())
li1=list(map(int,input().split()))
li2=list(map(int,input().split()))
li3=list(map(int,input().split()))
li1.sort()
li2.sort()
li3.sort()
flag1=0
flag2=0
ans1=0
ans2=0
for i in range(n-1):
	if flag1==0 and li1[i]!=li2[i]:
		ans1=li1[i]
		flag1=1
	elif flag1==0 and i==n-2:
		ans1=li1[-1]
		flag1=1

	if flag2==0 and i==n-2:
		ans2=li2[-1]
		flag2=1

	elif flag2==0 and li2[i]!=li3[i] :
		ans2=li2[i]
		flag2=1
print(ans1)
print(ans2)


