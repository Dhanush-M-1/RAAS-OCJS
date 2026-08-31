"""609C"""
# import math
# import sys
def main():
	n,m = map(int,input().split())
	a = list(map(int,input().split()))
	b = list(map(int,input().split()))
	arr  = []
	for i in range(n):
		temp = (b[0]-a[i])
		if temp<0:
			temp+=m
		arr.append(temp)
	arr.sort()
	b.sort()
	for i in range(n):
		arr2 = []
		flag = True
		for j in range(n):
			arr2.append((a[j]+arr[i])%m)
		arr2.sort()
		for k in range(n):
			if b[k]!=arr2[k]:
				flag = False
				break
		if flag==True:
			print(arr[i])
			return

	return	
main()
# def test():
# 	t = int(input())
# 	while t:
# 		main()
# 		t-=1
# test()
