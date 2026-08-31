""" 616C """
# import math
# import sys
def main():
	# n,m,k = map(int,input().split())
	# a = list(map(int,input().split()))
	string1,string2 = map(str,input().split())
	string1 = list(string1)
	# string2 = list(string2)
	length = len(string1)
	for i in range(length):
		index = i
		for j in range(length-1,i,-1):
			if string1[j]<string1[index]:
				index = j
				# break
		if index!=i:
			string1[i],string1[index] = string1[index],string1[i]
			break
	if ''.join(string1)<string2:
		print(''.join(string1))
	else:
		print("---")
	return

# main()
def test():
	t = int(input())
	while t:
		main()
		t-=1
test()
