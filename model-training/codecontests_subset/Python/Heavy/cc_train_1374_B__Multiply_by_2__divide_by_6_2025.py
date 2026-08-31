###DO NOT KNOW THE ANSWER...I AM REALLY SAD###

query=int(input())
for _ in range(query):
	n=int(input())
	c3=c2=0	#Counts how many times the number can be divided by 3 and 2
	#n=2**c2*3**c3
	#if needs to be made c3=0; n=2**(c2-c3)*3**0
	while(n%3==0):
		n//=3
		c3+=1
	while(n%2==0):
		n//=2
		c2+=1
	if c2>c3:	#if c2>c3 then there will be no 6 left to divide, only 2 can be mutiplied, if c2>c3 division by 2 is implied
		print(-1)
	elif n!=1:	#if not n==1
		print(-1)
	else:
		print(c3+(c3-c2))	#c3-c2 means how many times 2 is to be multiplied

# Video ref: https://www.youtube.com/watch?v=ekxYAYio9Xg
#Video 2: https://www.youtube.com/watch?v=sPl79SlXwRc