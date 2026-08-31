'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineerin College
    Date:10/04/2020
'''
from math import gcd,sqrt,ceil
def ii():return int(input())
def si():return input()
def mi():return map(int,input().split())
def li():return list(mi())


def main():
    
    
    for _ in range(ii()):
        
        n=ii()
        f=0
        a=[]
        
        for i in range(n):
            a.append(li())  
        if(a[0][0]<a[0][1]):
            f=1
        for i in range(1,n):
            if(a[i][0]<a[i-1][0] or a[i][1]<a[i-1][1]):
                f=1
                break
            if(a[i][0]<a[i][1]):
                f=1
                break
            if(a[i][1]>a[i-1][1]):
                x=a[i][1]-a[i-1][1]
                if(a[i][0]<(a[i-1][0]+x)):
                    f=1
                    break
        if(f):
            print('NO')
        else:
            print('YES')
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
if __name__=="__main__":
    main()