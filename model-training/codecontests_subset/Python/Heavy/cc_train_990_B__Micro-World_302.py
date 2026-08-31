#Author : Zahin uddin
#Github : https://github.com/Zahin52


from sys import *
#import math
#import queue
from collections import Counter
input=stdin.readline
listInput=lambda:list(map(int,input().strip().split()))
lineInput= lambda:map(int,input().strip().split())
sJoin=lambda a,sep : f'{sep}'.join(a)
arrJoin=lambda a,sep : f'{sep}'.join(map(str,a))
#print=stdout.write
def isPrime(n):
    if(n <= 1):
        return False
    if(n <= 3):
        return True
    if(n % 2 == 0 or n % 3 == 0):
        return False
    for i in range(5,int(math.sqrt(n) + 1), 6):
        if(n % i == 0 or n % (i + 2) == 0):
            return False
    return True
def main():
    n,k=lineInput()
    arr=listInput()
    arr=sorted(arr)
    d=Counter(arr)
    c=0
    #print(arr)
    for i in range(1,len(arr)):
        if arr[i]>arr[i-1] and arr[i]<=arr[i-1]+k:
            d[arr[i-1]]=0
    #print(d)
    for i,v in d.items():
        #print(i)
        c+=d[i]
    print(c)
if __name__ == "__main__":
    main()

	 	 		   		    		   	 	 		