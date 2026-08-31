import math

def lcm(x, y):
	return x*y/gcd(x, y)

def gcd(x, y):
	if x == 0:
		return y
	return gcd(y%x, x)

X = int(input())
pairs = []
for i in range(1,int(math.sqrt(X))+1):
	if X%i == 0:
		a = i
		b = int(X/i)
		pairs.append((a, b))

minimum = float("Inf")
for i in pairs:
	if lcm(i[0], i[1]) == X:
		maximum = max(i[0], i[1])
		if (minimum > maximum):
			minimum = maximum
			t1 = min(i[0], i[1])
			t2 = maximum
print(t1, t2)

# minimum = float("Inf")
# for i in pairs:
# 	maximum = max(i)
# 	if (minimum > maximum):
# 		minimum = maximum
# 		tup = i
# print(tup[0], tup[1])