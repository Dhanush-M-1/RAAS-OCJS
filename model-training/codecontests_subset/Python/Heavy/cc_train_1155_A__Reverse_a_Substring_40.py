from sys import stdin,stdout
from itertools import combinations
from collections import defaultdict


def listIn():
    return list((map(int,stdin.readline().strip().split())))

def stringListIn():
    return([x for x in stdin.readline().split()])
    
def intIn():
    return (int(stdin.readline()))

def stringIn():
    return (stdin.readline().strip())


if __name__=="__main__":
    n=intIn()
    s=stringIn()
    flag=False
    for i in range(n-1):
        if s[i]>s[i+1]:
            flag=True
            break
    if flag:
        print('YES')
        print(i+1,i+2)
    else:
        print('NO')
    
    
    
    
    
    
    
    
    
    
    