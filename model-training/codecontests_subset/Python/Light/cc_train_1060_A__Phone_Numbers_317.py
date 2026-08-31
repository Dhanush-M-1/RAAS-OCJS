N = int(input())
s = input()
n = N//11
j=0
for i in range(N):
	if(j==n):
		break
	if(s[i]=='8'):
		j+=1

print(j)