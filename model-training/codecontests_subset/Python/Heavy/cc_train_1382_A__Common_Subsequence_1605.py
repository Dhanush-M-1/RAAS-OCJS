#_______________________________________________________________#
def fact(x):
	if x == 0:
		return 1
	else:
		return x * fact(x-1)
def lower_bound(li, num): #return 0 if all are greater or equal to
	answer = len(li)-1
	start = 0
	end = len(li)-1

	while(start <= end):
		middle = (end+start)//2
		if li[middle] >= num:
			answer = middle
			end = middle - 1
		else:
			start = middle + 1
	return answer #index where x is not less than num
def upper_bound(li, num): #return n-1 if all are small or equal
	answer = -1
	start = 0
	end = len(li)-1

	while(start <= end):
		middle = (end+start)//2

		if li[middle] <= num:
			answer = middle
			start = middle + 1
		
		else:
			end = middle - 1
	return answer #index where x is not greater than num

def abs(x):
	return x if x >=0 else -x
def binary_search(li, val, lb, ub): # ITS A BINARY
	ans = 0
	while(lb <= ub):
		mid = (lb+ub)//2
		#print(mid, li[mid])
		if li[mid] > val:
			ub = mid-1
		elif val > li[mid]:
			lb = mid + 1
		else:
			ans = 1
			break
	return ans

def sieve_of_eratosthenes(n):
	ans = []
	arr = [1]*(n+1)
	arr[0],arr[1], i = 0, 0, 2
	while(i*i <= n):
		if arr[i] == 1:
			j = i+i
			while(j <= n):
				arr[j] = 0
				j += i
		i += 1
	for k in range(n):
		if arr[k] == 1:
			ans.append(k)
	return ans
def nc2(x):
	if x == 1:
		return 0
	else:
		return x*(x-1)//2
def kadane(x): #maximum subarray sum
	sum_so_far = 0
	current_sum = 0
	for i in x:
		current_sum += i
		if current_sum < 0:
			current_sum = 0
		else:
			sum_so_far = max(sum_so_far,current_sum)
	return sum_so_far
def mex(li):
	check = [0]*1001
	for i in li:
		check[i] += 1
	for i in range(len(check)):
		if check[i] == 0:
		 return i 
def sumdigits(n):
	ans = 0
	while(n!=0):
		ans += n%10
		n //= 10
	return ans

def product(li):
	ans = 1
	for i in li:
		ans *= i
	return ans
def maxpower(n,k):
	cnt = 0
	while(n>1):
		cnt += 1
		n //= k
	return cnt

#_______________________________________________________________#
'''
      ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
   ▄███████▀▀▀▀▀▀███████▄
░▐████▀▒▒Aestroix▒▒▀██████
░███▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▀████
░▐██▒▒▒▒▒KARMANYA▒▒▒▒▒▒████▌         ________________
░▐█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▌  ? ?   |▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒|
░░█▒▒▄▀▀▀▀▀▄▒▒▄▀▀▀▀▀▄▒▒▐███▌   ?    |___CM ONE DAY___|
░░░▐░░░▄▄░░▌▐░░░▄▄░░▌▒▐███▌     ? ? |▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒|
░▄▀▌░░░▀▀░░▌▐░░░▀▀░░▌▒▀▒█▌    ? ?    
░▌▒▀▄░░░░▄▀▒▒▀▄░░░▄▀▒▒▄▀▒▌      ? 
░▀▄▐▒▀▀▀▀▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒█     ? ? 
░░░▀▌▒▄██▄▄▄▄████▄▒▒▒▒█▀       ? 
░░░░▄█████████ ████=========█▒▒▐▌
░░░▀███▀▀████▀█████▀▒▌
░░░░░▌▒▒▒▄▒▒▒▄▒▒▒▒▒▒▐
░░░░░▌▒▒▒▒▀▀▀▒▒▒▒▒▒▒▐
░░░░░████████████████
'''
from math import *
from collections import deque
max_steps = 100005
for _ in range(int(input())):
#for _ in range(1):
	#n = int(input())
	#l,r,m = map(int,input().split())
	#st1 = input()
	#st2 = input()
	n,m = map(int,input().split())
	a = list(map(int,input().split()))
	b = list(map(int,input().split()))
	#s = list(st)
	ans = 0
	for i in a:
		if i in b:
			ans = i
			break
	if ans == 0:
		print('NO')
	else:
		print('YES')
		print(1,ans)
		
		









	




