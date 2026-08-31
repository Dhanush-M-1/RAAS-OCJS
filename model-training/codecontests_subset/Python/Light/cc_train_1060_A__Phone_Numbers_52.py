length=int(input())
num=input()
p=0

for i in range(length):
	if num[i]=='8':
		p+=1 #Counts the number of '8' in string
if length>=11:
	if p>=(length//11):
		print(length//11)
	else:
		print(p)	#what if there are '8' enuf to create a number? then the no. of numbers created will be p as '8' is required to make a number
else:
	print(0)