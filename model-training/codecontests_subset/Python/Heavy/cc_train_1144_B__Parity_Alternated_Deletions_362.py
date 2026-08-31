"""609C"""
# import math
# import sys
def  main():
	n = int(input())
	a = list(map(int,input().split()))
	cnte = 0
	cnto = 0
	a.sort()
	for i in range(len(a)):
		if a[i]%2==0:
			cnte+=1
		else:
			cnto+=1
	if abs(cnte-cnto)<=1:
		print(0)
		return
	flag = True
	if cnto-cnte>=1:
		flag=False
	add = 0
	k = abs(cnte-cnto)-1
	for i in range(len(a)):
		if flag and a[i]%2==0:
			add+=a[i]
			k-=1
			if k==0:
				print(add)
				return
		elif flag==False and a[i]%2!=0:
			add+=a[i]
			k-=1
			if k==0:
				print(add)
				return
	return

main()
# def test():
# 	t= int(input())
# 	while t:
# 		main()
# 		t-=1
# test()