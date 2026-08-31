p=input()
n=int(input())
s=[input() for i in range(n)]
for i in range(n):
	for j in range(n):
		if p in s[j]+s[i]:
			print("YES")
			exit()
print("NO")