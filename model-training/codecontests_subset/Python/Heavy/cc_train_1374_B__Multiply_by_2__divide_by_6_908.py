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
	n = int(input())
	temp = n
	cnt3 = 0
	cnt2 = 0
	if(n==1):
		print(0)
		return
	# if()
	while n>1 and (temp%2==0 or temp%3==0):
		if temp%3==0:
			temp = temp//3
			cnt3+=1
		if temp%2==0:
			temp = temp//2
			cnt2+=1
	if(temp!=1):
		print(-1)
		return
	if(cnt3==cnt2):
		print(cnt3)
		return
	if(cnt3>cnt2):
		print((cnt3-cnt2)+cnt3)
		return
	print(-1)
	return
# main()
def test():
	t = int(input())
	while t:
		main()
		t-=1
test()