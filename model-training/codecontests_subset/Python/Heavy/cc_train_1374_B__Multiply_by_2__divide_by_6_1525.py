import sys
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

def LAR(n):
	num_3s=0
	num_6s = 0
	while n%6 ==0:
		n = n/6
		num_6s +=1
	while(n%3 == 0):
		n = n/3
		num_3s +=1
	if n == 1:
			operations = num_3s +num_6s + num_3s
			print(operations)
			return 0
	else:
		print("-1")
		return 0
	print("-1")
  


test= inp()
for i in range(0,int(test)):
	n = inp()
	num = LAR(n)