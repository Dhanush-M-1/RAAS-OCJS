errors=int(input())
a=list(map(int,input().split(" ")))
dictErrors={}
for error in a:
	if error not in dictErrors:
		dictErrors[error]=[1,0,0]
	else:
		dictErrors[error][0]+=1

debug1=list(map(int,input().split(" ")))
for deb in debug1:
	dictErrors[deb][1]+=1

debug2=list(map(int,input().split(" ")))
for deb in debug2:
	dictErrors[deb][2]+=1


corrections=[-1,-1]
for i in range(2):
	for key in dictErrors:
		if(dictErrors[key][i]>dictErrors[key][i+1]):
			corrections[i]=key
			break

print(corrections[0])
print(corrections[1])