'''
    Auther: ghoshashis545 Ashis Ghosh
    college: jalpaiguri Govt Enggineering College
    Date:14/03/2020
'''
from math import ceil,sqrt,gcd,log,floor
from collections import deque
def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().strip().split(" "))
def li(): return list(mi())
def main():
    #for _ in range(ii()):
    
    a,b=mi()
    ans=a
    c1=1
    while(1):
        c=0
        for i in range(c1,a+1):
            if(i%b==0):
                c+=1
        if(c==0):
            break
        c1=a+1
        a+=c
    print(a)
    
    
    
    
    
    
    
    
    
    
    



    


    
if __name__ == "__main__":
    main()