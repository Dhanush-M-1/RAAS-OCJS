def doit(number,recycle_number,):
	if((number)<recycle_number):
		return number
	temp=0
	temp=number-number%recycle_number
	
	number=temp//recycle_number+number%recycle_number
	
	return temp+doit(number,recycle_number)

numbers=list(map(int,input().split()))
print(doit(numbers[0],numbers[1]))

