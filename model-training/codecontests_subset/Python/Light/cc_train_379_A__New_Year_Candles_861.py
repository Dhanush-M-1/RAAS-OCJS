a,b = map(int,input().split())
def time(a,b,c = 0):
	if a+c < b:
		return a
	elif a == b:
		return a + 1
	else:
		return a + time((a+c)//b,b,(a+c)%b)
print(time(a,b))