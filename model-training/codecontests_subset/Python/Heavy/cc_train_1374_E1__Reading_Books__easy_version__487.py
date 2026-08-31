""" 616C """
""" 1152B """
# import math
# import sys
def main():
	# n ,m= map(int,input().split())
	# arr = list(map(int,input().split()))
	# b = list(map(int,input().split()))
	# n = int(input())
	# string = str(input())
	n ,k= map(int,input().split())
	a = []
	b = []
	c = []
	for _ in range(n):
		t,first,second = map(int,input().split())
		if(first==second):
			if(second==1):
				c.append(t)
		elif(first==1):
			a.append(t)
		elif second==1:
			b.append(t)
	if(len(a)+len(c)<k or len(b)+len(c)<k):
		print(-1)
		return
	a.sort()
	b.sort()
	c.sort()
	l = 0
	r = 0
	m = 0
	ans = 0
	for i in range(k):
		if((l>=len(a) or r>=len(b))  or (m<len(c) and l<len(a) and r<len(c) and c[m]<(a[l]+b[r]))):
			ans += c[m]
			m+=1
		else:
			ans += (a[l]+b[r])
			l+=1
			r+=1
	print(ans)
	return
main()
# def test():
# 	t = int(input())
# 	while t:
# 		main()
# 		t-=1
# test()