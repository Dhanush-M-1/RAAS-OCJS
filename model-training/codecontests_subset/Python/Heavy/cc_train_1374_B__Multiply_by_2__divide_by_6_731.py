TC=int(input())
def twothree(l):
	ans=l
	two,three,twocount,threecount=True,True,0,0
	while ans!=1:
		two,three=True,True
		if ans%2==0:
			ans=ans/2
			twocount+=1
			two=False
		if ans%3==0:
			ans=ans/3
			threecount+=1
			three=False
		if two and three:
			break
	if ans!=1:
		return -1,-1
	else:
		return twocount,threecount

		

def solution(l):
	if l==1:
		return 0
	else:
		two,three=twothree(l)
		if two==-1:
			return -1
		else:
			if two>three:
				return -1
			else:
				return (three-two)+three


for _ in range(TC):
	l=int(input())
	print(solution(l))