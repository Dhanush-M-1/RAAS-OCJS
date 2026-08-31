import math

n,k=list(map(int,input().split()))

l=list(map(int,input().split()))

mini=math.inf
for i in l:
	if k%i==0 and k//i<=mini:
		mini=k//i

print(mini)