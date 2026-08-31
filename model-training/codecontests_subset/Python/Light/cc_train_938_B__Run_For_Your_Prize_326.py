getInputList = lambda : list(input().split())
getInputIntList = lambda : list(map(int,input().split()))

#for t in range(n):
n = int(input())
arr = getInputIntList()
#by_a = []
#by_b = []
final = []
a = 1
b = 10**6
for i in arr:
	final.append(min(i-a,b-i))	
print(max(final))		
		