
import sys
sys.setrecursionlimit(10000)
# default is 1000 in python


t = int(input())
# t = 1

for _ in range(t):
	n, m = list(map(int, input().split()))
	
	a = list(map(int, input().split()))
	b = list(map(int, input().split()))

	a_dict = {}
	for i in a:
		a_dict[i] = 1
	yes = 0
	for i in b:
		if i in a_dict:
			yes = 1
			break
	if yes == 1:
		print("YES")
		print("1", i)
	else:
		print("NO")


# try:
	# raise Exception
# except:
	# print("-1")


# from collections import OrderedDict 
# mydict = OrderedDict() 


# thenos.sort(key=lambda x: x[2], reverse=True)

# int(math.log(max(numbers)+1,2))

# 2**3 (power)

# a,t = (list(x) for x in zip(*sorted(zip(a, t))))

# to copy lists use .copy()

# pow(p, si, 1000000007) for modular exponentiation

# my_dict.pop('key', None)
# This will return my_dict[key] if key exists in the dictionary, and None otherwise.



# bin(int('010101', 2))