import math

def gcd(a,b): 
    if (b == 0): 
         return a 
    return gcd(b, a%b) 

def lcm(a,b): 
    return (a*b) / gcd(a,b) 

def bs(arr, l, r, x): 
    while l <= r: 
        mid = l + (r - l)//2; 
        if(arr[mid]==x): 
            return arr[mid]
        elif(arr[mid]<x): 
            l = mid + 1
        else: 
            r = mid - 1
    return -1

def swap(list, pos1, pos2): 
      
    list[pos1], list[pos2] = list[pos2], list[pos1] 
    return list

def subarrayBitwiseOR(A): 
    res = set()
    pre = {0} 
    for x in A: 
        pre = {x | y for y in pre} | {x} 
        res |= pre 
    return len(res) 


t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    
    x = a[0]
    y = a[1]
    for i in range(2,n):
        z = a[i]
        if(x+y<=z or y+z<=x or z+x<=y):
            print(1,2,i+1)
            break
    else:
        print(-1)
