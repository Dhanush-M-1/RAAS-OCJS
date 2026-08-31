import sys,math

def file():
	sys.stdin = open('input.py', 'r')
	sys.stdout = open('output.py', 'w') 
	'''0
	-1
	2
	-1
	-1
	12
	36'''

def get_array():
	l=list(map(int, input().split()))
	return l
#file()	
def main():
	for tt in range(int(input())):
		#l=get_array()
		#x,y,n=l[0],l[1],l[2]
		n=int(input())
		two,thr=0,0
		while(n%2==0):
			n=n//2
			two+=1
		while(n%3==0):
			n=n//3
			thr+=1	
		if(n!=1):
			print(-1)
		else:
			if(two>thr):
				print(-1)
			else:
				ans=thr
				ans+=(thr-two)
				print(ans)
				


			
			

			


			
			





	
			
	














if __name__ == '__main__':
    main()
