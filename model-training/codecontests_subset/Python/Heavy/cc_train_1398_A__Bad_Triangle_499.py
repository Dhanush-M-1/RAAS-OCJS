import sys
from collections import Counter
from math import ceil,gcd,log
from bisect import bisect ,bisect_left,bisect_right
input = sys.stdin.readline

def check(a, b, c): 
	if (a + b <= c) or (a + c <= b) or (b + c <= a) : 
		return False
	else: 
		return True		


def solve(n,arr):
    a = arr[0]
    b = arr[1]
    p = arr.index(a)
    q = arr.index(b)
    flag  =False
    arr = arr[2:]
    for j,i in enumerate(arr):
        c = i
        if (not check(a,b,c)):
            ans = (a,b,j)
            flag = True
            break
        else:
            continue
    
    
    if(flag):
        
        if(p==q):
            q+=1
        print(p+1,q+1,3+ans[-1])
        
    else:   
        print(-1)
    return
    
    
def main():
    for _ in range(int(input())):
        n = int(input())
        arr = list(map(int,input().split()))
        solve(n,arr)
        
    return



if __name__ == '__main__':
    main()