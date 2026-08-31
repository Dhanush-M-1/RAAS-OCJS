import sys

def main():
	n = int(input())
	al = [[int(x),n-i] for i,x in enumerate(input().split())]
	al.sort()
	al.reverse()
	arr = [[[]for i in range(n)]for i in range(n)]

	for i in range(1,n+1):
		for j in range(i-1,n):
			arr[j][n-al[i-1][1]] = al[i-1][0]

	for i in range(n):
		arr[i] = list(filter(None, arr[i])) 

	q = int(input())

	for _ in range(q):
		k,ind = map(int,input().split())
		print(arr[k-1][ind-1])

main()