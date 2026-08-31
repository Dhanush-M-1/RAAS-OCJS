password=input()
n=int(input())
strings=[input() for i in range(n)]
if password in strings:
	print("YES")
else:
	letters=list(password)
	strings0=[k for k in strings if letters[0] in list(k)[1]]
	strings1=[k for k in strings if letters[1] in list(k)[0]]
	if len(strings0)>0 and len(strings1)>0:
		print("YES")
	else:
		print("NO")
