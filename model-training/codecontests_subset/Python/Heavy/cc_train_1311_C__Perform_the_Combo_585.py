
# _____  _      _  _                           _      _   __                   _                         _      _  _         
# /  ___|| |    (_)| |                         (_)    | | / /                  (_)                       | |    (_)| |        
# \ `--. | |__   _ | |_  ___  _   _  _ __  ___  _     | |/ /   __ _  _ __ ___   _  _ __ ___    __ _  ___ | |__   _ | |_  __ _ 
#  `--. \| '_ \ | || __|/ __|| | | || '__|/ _ \| |    |    \  / _` || '_ ` _ \ | || '_ ` _ \  / _` |/ __|| '_ \ | || __|/ _` |
# /\__/ /| | | || || |_ \__ \| |_| || |  |  __/| | _  | |\  \| (_| || | | | | || || | | | | || (_| |\__ \| | | || || |_| (_| |
# \____/ |_| |_||_| \__||___/ \__,_||_|   \___||_|( ) \_| \_/ \__,_||_| |_| |_||_||_| |_| |_| \__,_||___/|_| |_||_| \__|\__,_|
#                                                |/                                                                          

# import math
# def SieveOfEratosthenes(n): 
# 	prime = [True for i in range(n + 1)] 
# 	p = 2
# 	while (p * p <= n): 
# 		# If prime[p] is not changed, then it is a prime 
# 		if (prime[p] == True): 
# 			# Update all multiples of p 
# 			for i in range(p * 2, n + 1, p): 
# 				prime[i] = False
# 		p += 1
# 	prime[0]= False
# 	prime[1]= False
# 	return prime


# file = open("input", "r")
def getIn():
	# return file.readline().strip()
	return input().strip()

t = int(getIn())
for _ in range(t):
	n, m = list(map(int, getIn().split(" ")))
	s = getIn()
	marr = list(map(int, getIn().split(" ")))

	abcd = [0 for i in range(26)]

	bigshit = [[0 for j in range(n)] for i in range(26)]
	# print(bigshit)
	# Parsing shit
	for i in range(len(s)):
		c = ord(s[i]) - 97
		# print(c)
		for j in range(26):
			if i > 0:
				bigshit[j][i] = bigshit[j][i-1]
		bigshit[c][i] += 1
	# for l in bigshit:
		# print(l)



	for ind in marr:
		for i in range(26):
			abcd[i] += bigshit[i][ind-1]

	for i in range(26):
		abcd[i] += bigshit[i][n-1]

	for ii in abcd:
		print(ii, end=" ")
	print()

