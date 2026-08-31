import copy
def get_output(array,length):
	max=array[-1]
	i=0
	while(i!=length-2):
		sum=array[i]+array[i+1]
		if sum<=max:
			return i+1,i+2,length
		else:
			i+=1
	return -1
test_cases=int(input())
for i in range(test_cases):
	length=int(input())
	array=[int(i) for i in input().split()]
	res=get_output(array,length)
	if res!=-1:
		for i in res:
			print(i,end=" ")
		print()
	else:
		print(res)

