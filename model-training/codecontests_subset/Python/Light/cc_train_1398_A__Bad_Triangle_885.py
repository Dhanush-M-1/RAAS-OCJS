
def findDegenerateTriangle(a):
	if a[-1] >= a[0] + a[1]:
		print("1 2 " + str(len(a)))
	else:
		print("-1")



def convertToInt(a):
	for i in range(0, len(a)):
		a[i] = int(a[i])
	return a


t = int(input())

for i in range(t):
	n = int(input())
	a = input().split()
	a = convertToInt(a)
	findDegenerateTriangle(a)





