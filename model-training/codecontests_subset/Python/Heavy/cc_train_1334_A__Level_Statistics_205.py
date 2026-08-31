#qn given an arr of size n for every  i position find a min j such that j>i and arr[j]>arr[i]
#it prints the position of the nearest .
import sys
input = sys.stdin.readline
 #qn given an arr of size n for every  i position find a min j such that j>i and arr[j]>arr[i]
#it prints the position of the nearest .
# import sys
import heapq 
import copy
#heapq.heapify(li) 
#
#heapq.heappush(li,4) 
#
#heapq.heappop(li)
#
# &	Bitwise AND Operator	10 & 7 = 2
# |	Bitwise OR Operator	10 | 7 = 15
# ^	Bitwise XOR Operator	10 ^ 7 = 13
# ~	Bitwise Ones’ Compliment Operator	~10 = -11
# <<	Bitwise Left Shift operator	10<<2 = 40
# >>	Bitwise Right Shift Operator
############ ---- Input Functions ---- #######Start#####
def inp():
	return(int(input()))
def inlt(): 
	return(list(map(int,input().split())))
def insr():
	s = input()
	return(list(s[:len(s) - 1]))
def invr():
	return(map(int,input().split()))
 ############ ---- Input Functions ---- #######End#####   
def bin_search(arr,l,r,val):#strickly greater
	if arr[r] <= val:
		return r+1	
	if r-l < 2:
		if arr[l]>val:
			return l
		else:
			return r
	mid = int((l+r)/2)
	if arr[mid] <= val:
		return bin_search(arr,mid,r,val)
	else:
		return bin_search(arr,l,mid,val)

# def pr_list(a):
# 	print(*a, sep=" ")
def main():
	tests =  inp()
	mod = 1000000007
	for test in range(tests):
		flag = 1
		n = inp()
		c = []
		p = []
		for _ in range(n):
			[a,b] = inlt()
			p.append(a)
			c.append(b)
		if p[0] < c[0]:
			print("NO")
			continue
		for i in range(1,n):
			if not(p[i]>=p[i-1] and c[i]>=c[i-1] and p[i]-p[i-1] >= c[i] - c[i-1] and p[i]>=c[i]):
				print("NO")
				flag = 0
				break
		if flag == 1:
			print("YES")



	





	return 0


# if for two position i,j such that j<i and arr[j]>arr[i] I wont need to store the position i as I wont requre it for any further computation. I cound simply use i instead of j.
#to do that i main tain a stack which is initiallized with the last elment and I traverse the arr backwords because for any ith entry the answer does not depends on 0 to i-1.
# for every element I would continue to pop the stack (from last) till i recieve an elemnt larger than current one. The elemnt which i poped are not needed as i could use current elemnt.
# the order is n as an element only enters the stack ones.
if __name__== "__main__":
  main()