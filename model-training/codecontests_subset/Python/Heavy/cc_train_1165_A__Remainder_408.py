l=list(map(int,input().split()))
n=10**l[0]
x=10**l[1]
x=str(x)
y=10**l[2]
y=str(y)

num=input()
lx=len(x)
ly=len(y)
lx=lx-1
count=0

for i in range(0,ly):
	if y[ly-i-1]==num[len(num)-i-1]:
		continue
	else:
		count+=1

for j in range(0,lx-ly):
	if num[len(num)-1-ly-j]=='0':
		continue
	else:
		count+=1

# counter=0

# for i in range(0,lx):
# 	if counter<ly:
# 		if y[ly-i-1]==num[len(num)-i-1]:
# 			continue
# 		else:
# 			count+=1
# 		counter+=1
# 	else:
# 		if num[len(num)-1-ly-j]=='0':
# 			continue
# 		else:
# 			count+=1



print(count)



