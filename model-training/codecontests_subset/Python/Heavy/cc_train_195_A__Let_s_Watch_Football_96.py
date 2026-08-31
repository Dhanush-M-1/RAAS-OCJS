#Author : Zahin uddin
#Github : https://github.com/Zahin52


from sys import *
#import math
#import queue
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
def binarySearch(low,high,a,b,c,data):
    while low<=high:        
        mid=(low+high)//2    
        oneSecEarly=((mid*b)+(b*(c-1))) 
        #print(mid,oneSecEarly,data-oneSecEarly)   
        if 0<data-oneSecEarly<=b:
            return mid
            break
        elif data-oneSecEarly<=0:
            high=mid-1
        elif data-oneSecEarly>b:
            low=mid+1
def main():
    a,b,c=lineInput()
    downloadtime=((a*c)+b-1)//b
    #print(downloadtime)
    ans=binarySearch(0,downloadtime,a,b,c,(a*c))
    print(ans)
    
    
if __name__ == "__main__":
    main()
