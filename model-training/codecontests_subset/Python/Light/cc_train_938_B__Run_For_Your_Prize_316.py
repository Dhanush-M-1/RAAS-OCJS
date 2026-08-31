n=int(input())
A=[int(i) for i in input().split()]
mon_temps=0
son_temps=0
i=0
while i<n and A[i]<=500000:
	mon_temps=A[i]-1
	i+=1
i=n-1
while i>=0 and A[i]>500000:
	son_temps=1000000-A[i]
	i-=1
print(max(mon_temps,son_temps))
