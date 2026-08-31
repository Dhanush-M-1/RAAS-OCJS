import math

def gcd(a,b):
	if b==0:
		return a
	else:
		return gcd(b,a%b)

def main():
	n = int(input())
	if n<=3:
		if n==3:
			print(6)
		else:
			print(n)
	else:
		if n%2==1:
			print(n*(n-1)*(n-2))
		else:
			cr = (n-1) * (n-2) * (n-3)
			for i in range(max(n-50,1),n+1):
				for j in range(max(n-50,1),n+1):
					for k in range(max(n-50,1),n+1):
						lcm = i*j // gcd(i,j)
						lcm = lcm*k // gcd(lcm,k)
						#print(i," ",j," ",k," ",lcm)
						if lcm>cr:
							cr = lcm
			print(cr)
			
if __name__=='__main__':
	main()