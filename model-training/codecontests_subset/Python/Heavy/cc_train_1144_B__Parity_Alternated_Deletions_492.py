# import sys
# sys.stdin=open("input.in","r")
# sys.stdout=open("output.out","w")
n=int(input())
L=list(map(int,input().split()))
L=sorted(L)
odd,even=[],[]
for i in range(n):
	if L[i]%2==0:
		even.append(L[i])
	else:
		odd.append(L[i])
if abs(len(odd)-len(even)==0) or len(odd)-len(even)==0:
	print("0")
else:
	if len(even)>len(odd):
		sum=0
		for i in range(len(even)-len(odd)-1):
			sum+=even[i]
		print(sum)
	else :
		sum=0
		for j in range(len(odd)-len(even)-1):
			sum+=odd[j]
		print(sum)







