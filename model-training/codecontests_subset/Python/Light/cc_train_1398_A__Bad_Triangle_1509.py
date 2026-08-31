
def solve(arr,n):

	if(arr[-1]>=arr[0]+arr[1]):
		print(1,2,n)
		return 

	print(-1)

t = int(input())
for _ in range(t):
	
	n = int(input())
	arr = list(map(int,input().split()))
	solve(arr,n)