import math
def  main():
	n,x,y = map(int,input().split())
	y = y/100
	people = n*y
	# print(math.ceil(people))
	print(int(math.ceil(people)-x)) if int(math.ceil(people)-x)>0 else print(0)


main()