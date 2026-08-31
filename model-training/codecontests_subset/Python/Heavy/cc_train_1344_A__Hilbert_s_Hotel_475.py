import sys,math
#sys.setrecursionlimit(100000000)
input = sys.stdin.readline
 
############ ---- USER DEFINED INPUT FUNCTIONS ---- ############
def inp():
    return(int(input()))
def inara():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))
################################################################
############ ---- THE ACTUAL CODE STARTS BELOW ---- ############

t=inp()

for _ in range(t):
	n=inp()
	ara=inara()
	ans=[]
	for i in range(n):
		x=i+ara[i]
		x%=n
		x+=n
		x%=n
		ans.append(x)
	ans.sort()
	flag=True
	for i in range(n):
		flag&=(i==ans[i])
	
	if flag:
		print("YES")
	else:
		print("NO")
	
