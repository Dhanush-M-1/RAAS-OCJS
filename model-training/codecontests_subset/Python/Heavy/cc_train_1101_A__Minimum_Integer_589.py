from math import ceil,floor,gcd
from collections import deque as queue

def decToBin(number,size=64):
    return bin(number)[2:].zfill(size)

def lcm(a,b):
	return (a*b)//gcd(a,b)

def binarySearch (arr, l, r, x): 

    if r >= l: 
  
        mid = l + (r - l)/2

        if arr[mid] == x: 
            return mid 
          
        elif arr[mid] > x: 
            return binarySearch(arr, l, mid-1, x) 
  
        else: 
            return binarySearch(arr, mid + 1, r, x) 
  
    else: 
        return -1

#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
q = int(input())
for _ in range(q):
    l,r,d = map(int,input().split())
    if d < l:
        print(d)
    else:
        x = r//d
        x += 1
        x *= d
        print(x)