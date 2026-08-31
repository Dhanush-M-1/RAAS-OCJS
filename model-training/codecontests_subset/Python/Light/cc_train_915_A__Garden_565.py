def gcd(a, b): 
    if a == 0 :
        return b 
     
    return gcd(b%a, a)


if __name__=='__main__':

	a=str(input())
    
	a=a.split()

	x=0
	
	c=int(a[1])


	d=str(input())



	d=d.split()
     

	for i in d:


		if (gcd(int(i), c)==int(i)):
			if(int(i)>x):
				x=int(i)
			
	print(int(c/x))

