n=int(input())
s=input()
cnt8=0
for charr in s:
	if charr=="8":
		cnt8+=1
print(min(cnt8,n//11))