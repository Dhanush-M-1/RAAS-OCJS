import math,sys
from collections import Counter, defaultdict
from sys import stdin, stdout
#input = stdin.readline
lili=lambda:list(map(int,sys.stdin.readlines()))
li = lambda:list(map(int,input().split()))


  
def find_lcm(num1, num2):
    p=num1*num2
    return(p//find_gcd(num1,num2)) 

def find_gcd(x,y): 
      
    while(y): 
        x, y = y, x % y 
      
    return x 
      

n=int(input())
a=li()
lcm=max(a)
gcd1=find_gcd(a[0],a[1])
for i in range(2,n):
    if(a[i]!=0):
        gcd=find_lcm(lcm,a[i])
    gcd1=find_gcd(gcd1,a[i])
b=[]

for i in range(0,n):
    b.append(lcm-a[i])
gcd=find_gcd(b[0],b[1])
for i in range(2,n):
    gcd=find_gcd(gcd,b[i])
print(sum(b)//gcd,gcd)


