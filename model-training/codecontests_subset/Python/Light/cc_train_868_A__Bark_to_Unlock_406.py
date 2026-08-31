def BarkToUnlock(pswd,barkList):
	flag1=0
	flag2=0
	if pswd in barkList:
		return "YES"
	else:
		for b in barkList:
			if b[0]==pswd[1] and flag1==0:
				flag1=1
			if b[1]==pswd[0] and flag2==0:
				flag2=1

			if flag1 and flag2:
				return "YES"

	return "NO"

pswd = input()
n = int(input())
barkList=[]
while n>0:
	barkList.append(input())
	n-=1

print(BarkToUnlock(pswd,barkList))



