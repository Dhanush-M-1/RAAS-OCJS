

def main():
	n = int(input())
	a = []
	b = []
	for _ in range(n):
		x,y = map(int,input().split())
		a.append(x)
		b.append(y)
	start = a[0]
	cnt = 2
	if n==1:
		cnt = 1
	for i in range(1,len(a)-1):
		if start<a[i]-b[i]:
			cnt+=1
			start = a[i]
		elif a[i+1]>(a[i]+b[i]):
			cnt+=1
			start=a[i]+b[i]
		else:
			start = a[i]
	print(cnt)

	


main()
# t= int(input())
# while t:
# 	main()
# 	t-=1