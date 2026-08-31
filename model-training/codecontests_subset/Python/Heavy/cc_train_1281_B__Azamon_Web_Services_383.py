#qn given an arr of size n for every  i position find a min j such that j>i and arr[j]>arr[i]
#it prints the position of the nearest .
import sys
input = sys.stdin.readline
 #qn given an arr of size n for every  i position find a min j such that j>i and arr[j]>arr[i]
#it prints the position of the nearest .
# import sys
import heapq 
import copy
import math
#heapq.heapify(li) 
#
#heapq.heappush(li,4) 
#
#heapq.heappop(li)
#
# &	Bitwise AND Operator	10 & 7 = 2
# |	Bitwise OR Operator	10 | 7 = 15
# ^	Bitwise XOR Operator	10 ^ 7 = 13

# <<	Bitwise Left Shift operator	10<<2 = 40
# >>	Bitwise Right Shift Operator
'''############ ---- Input Functions ---- #######Start#####'''
def inp():
	return(int(input()))
def inlt(): 
	return(list(map(int,input().split())))
def insr():
	s = input()
	return(list(s[:len(s) - 1]))
def invr():
	return(map(int,input().split()))
 ############ ---- Input Functions ---- #######End
 # #####   

class Node:
    def _init_(self,val):
        self.data = val
        self.left = None
        self.right = None
##to initialize wire : object_name= node(val)##to create a new node
## can also be used to create linked list
class fen_tree:
    """Implementation of a Binary Indexed Tree (Fennwick Tree)"""
    
    #def __init__(self, list):
    #    """Initialize BIT with list in O(n*log(n))"""
    #    self.array = [0] * (len(list) + 1)
    #    for idx, val in enumerate(list):
    #        self.update(idx, val)

    def __init__(self, list):
        """"Initialize BIT with list in O(n)"""
        self.array = [0] + list
        for idx in range(1, len(self.array)):
            idx2 = idx + (idx & -idx)
            if idx2 < len(self.array):
                self.array[idx2] += self.array[idx]

    def prefix_query(self, idx):
        """Computes prefix sum of up to including the idx-th element"""
        # idx += 1
        result = 0
        while idx:
            result += self.array[idx]
            idx -= idx & -idx
        return result
    def prints(self):
        print(self.array)
        return
        # for i in self.array:
        #     print(i,end = " ")
        # return 
    def range_query(self, from_idx, to_idx):
        """Computes the range sum between two indices (both inclusive)"""
        return self.prefix_query(to_idx) - self.prefix_query(from_idx - 1)

    def update(self, idx, add):
        """Add a value to the idx-th element"""
        # idx += 1
        while idx < len(self.array):
            self.array[idx] += add
            idx += idx & -idx


def pre_sum(arr):
	#"""returns the prefix sum inclusive ie ith position in ans  represent sum from 0 to ith position"""
	p = [0]
	for i in arr:
		p.append(p[-1] + i)
	p.pop(0)
	return p

def pre_back(arr):
	#"""returns the prefix sum inclusive ie ith position in ans  represent sum from 0 to ith position"""
	p = [0]
	for i in arr:
		p.append(p[-1] + i)
	p.pop(0)
	return p
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
def search_leftmost(arr,val):
	def helper(arr,l,r,val):
		# print(arr)
		print(l,r)
		if arr[l] == val:
			return l
		if r -l <=1:
			if arr[r] == val:
				return r
			else:
				print("not found")
				return
		mid = int((r+l)/2)
		if arr[mid] >= val:
			return helper(arr,l,mid,val)
		else:
			return helper(arr,mid,r,val)
	return helper(arr,0,len(arr)-1,val)
def search_rightmost(arr,val):
	def helper(arr,l,r,val):
		# print(arr)
		print(l,r)
		if arr[r] == val:
			return r
		if r -l <=1:
			if arr[l] == val:
				return r
			else:
				print("not found")
				return
		mid = int((r+l)/2)
		if arr[mid] > val:
			return helper(arr,l,mid,val)
		else:
			return helper(arr,mid,r,val)
	return helper(arr,0,len(arr)-1,val)


def pr_list(a):
	print(*a, sep=" ")
def main():
	tests =  inp()
	# tests = 1
	mod = 1000000007
	limit = 10**18
	# print(limit)

	for test in range(tests):
		s = insr()
		for i in range(len(s)):
			if s[i] == " ":
				a = s[0:i]
				b = s[i+1:len(s)]
				break
		hashm = [ 0 for i in range (27)]
		for i in a:
			hashm[ord(i) - ord('A')]+=1
		def find_best(hashm):
			for i in range(len(hashm)):
				if hashm[i]!=0:
					top = i
					break
			return i
		top = find_best(hashm)
		for i in range(len(a)):
			if ord(a[i])- ord('A')  == top:
				hashm[top] -=1
				if hashm[top] == 0:
					top = find_best(hashm)
				# print(hashm)
			else:
				curr = a[i]
				for j in range(len(a)- 1,i,-1):
					if ord(a[j])- ord('A')  == top:
						break
				a[i] = a[j]
				a[j] = curr
				break
		# print(a) 	
		flag = 0
		for i in range(len(b)):
			# print(a[i],b[i])
			if i >=len(a):
				flag = 1
				break
			if a[i] < b[i]:
				flag = 1
				break
			if a[i]>b[i]:
				break

		if flag ==0:
			print("---")
		else:
			print("".join(a))
		# # for i in range()
		# for i in range(1,10):
		# 	print((i-2)%9 +1)

				
			
		




if __name__== "__main__":
  main()