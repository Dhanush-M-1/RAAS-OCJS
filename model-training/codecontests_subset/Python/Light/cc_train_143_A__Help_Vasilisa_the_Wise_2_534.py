"""609C"""
# import math
def  main():
	r1,r2 = map(int,input().split())
	c1,c2 = map(int,input().split())
	d1,d2 = map(int,input().split())

	# r1c1 = 0
	for i in range(1,10):
		r1c1 = i 
		r2c1 = c1 - r1c1
		r1c2 = r1 - r1c1
		r2c2 = d1 - r1c1
		if r2c1<=0 or r2c1>=10:
			continue
		if r1c2<=0 or r1c2>=10:
			continue
		if r2c2<=0 or r2c2>=10:
			continue		
		if r2c1+r2c2 == r2 and d2==r1c2+r2c1 and c2==r2c2+r1c2:
 			if len(set([r1c1,r2c2,r1c2,r2c1]))==4:
 				print(r1c1,r1c2)
 				print(r2c1,r2c2)
 				return
	print("-1")
	return

main()



# t= int(input())
# while t:
# 	main()
# 	t-=1