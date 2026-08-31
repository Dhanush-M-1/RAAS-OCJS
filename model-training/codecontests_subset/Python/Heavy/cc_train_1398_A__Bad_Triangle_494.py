# cook your dish here
def compute_lcm(num1, num2): 
    if(num1>num2): 
        num = num1 
        den = num2 
    else: 
        num = num2 
        den = num1 
    rem = num % den 
    while(rem != 0): 
        num = den 
        den = rem 
        rem = num % den 
    gcd = den 
    lcm = int(int(num1 * num2)/int(gcd)) 
    return lcm 
t = int(input())
import math
import collections
for i in range(t):
    
    n = int(input())
    a = list(map(int,input().split()))
    s = a[0]+a[1]
    for i in range(2,n):
        if s>a[i]:
            continue
        else:
            print(1,2,i+1)
            break
    else:
        print(-1)
        
