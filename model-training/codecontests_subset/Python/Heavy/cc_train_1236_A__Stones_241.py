# def max_stones(a,b,c):
# 	if b<=0:
# 		return 0
# 	elif (b<2 or a<1) and (b>=1 and c>=2):
# 		return 3+max_stones(a,b-1,c-2)
# 	elif (b<1 or c<2) and (a>=1 and b>=2):
# 		return 3+max_stones(a-1,b-2,c)
# 	res= max(max_stones(a-1,b-2,c),max_stones(a,b-1,c-2))
# 	if res==0:
# 		return 0
# 	return res+3

# def max_stones(b,c):
# 	if b==0:
# 		return 0
# 	count=0
# 	if b<c:
# 		t=c//2
# 		if t<b:
# 			count+=t
# 			b-=t
# 		else:
# 			return b*3
# 	else:
# 		count+=c//2
# 		b-=count
# 	if a<b:
# 		t=b//2
# 		if t<a:
# 			count+=t
# 			a-=t
# 		else:
# 			return (a*3)+(count*3)
# 	else:
# 		count+=b//2
# 		a-=count
# 	return count*3
	

# for z in range(int(input())):
# 	x=[int(i) for i in input().split()]
# 	print(max_stones(x[0],x[1],x[2]))

def max_stones(b,c):
	count=0
	if b<c:
		t=c//2
		if t<b:
			count+=t
			b-=t
		else:
			return [b*3]
	else:
		count+=c//2
		b-=count
	return [count*3,b]

def solution(a,b,c):
	first=max_stones(b,c)
	stones=first[0]
	if len(first)==2:
		stones+=max_stones(a,first[1])[0]
	return stones
for z in range(int(input())):
	x=[int(i) for i in input().split()]
	print(solution(x[0],x[1],x[2]))
