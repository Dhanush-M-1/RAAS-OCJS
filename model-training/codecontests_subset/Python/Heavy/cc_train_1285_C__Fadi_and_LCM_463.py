# cook your dish here

import math

def gcd(x, y): 
  
   while(y): 
       x, y = y, x % y 
  
   return x 

def main():
    n = int(input())
    ans = 10000000000000;
    nq = int(math.sqrt( n ))
    nq = nq+1
    for i in range(2,nq+1):
        if n%i == 0:
            a = i
            b = n/i
            temp = gcd(a,b)
            if temp==1:
                m = max(a,b)
                ans = min(ans,m)
    if ans == 10000000000000:
        print(str(n)+" 1")
    else:
        print(str(int(ans))+" "+str(int(n/ans)))

if __name__=="__main__":
    main()