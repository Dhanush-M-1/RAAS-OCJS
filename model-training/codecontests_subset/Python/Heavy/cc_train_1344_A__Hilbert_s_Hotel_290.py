from sys import stdin,stdout                           #
import math                                            #
import heapq                                           #
                                                       #
t = 1                                                  #
def aint():                                            #
	return int(input().strip())                        #
def lint():                                            #
	return list(map(int,input().split()))              #
def fint():                                            #
	return list(map(int,stdin.readline().split()))     #
                                                       #	
########################################################

def main():
	n=aint()
	l=lint()
	cnt=[0]*n
	for i in range(n):
		cnt[(i+l[i])%n]+=1
	for i in range(n):
		if cnt[i]>1:
			print("NO")
			break
	else:
		print("YES")
	#solve
t=int(input())

########################################################
for i in range(t):                                     #
	#print("Case #"+str(i+1)+":",end=" ")		       #
	main()                                             #