n=int(input())
s=input()
con=n//11

if (s.count('8')>=con) and (n>=11):
	print(con)
elif (s.count('8')!=0) and (n>=11):
	print(s.count('8'))
else:
	print(0)
	
