from math import *
#from bisect import *
#from collections import *
#from random import *
#from decimal import *"""
#from heapq import *
#from random import *
import sys
input=sys.stdin.readline
#sys.setrecursionlimit(3*(10**5))
global flag
def inp():
    return int(input())
def st():
    return input().rstrip('\n')
def lis():
    return list(map(int,input().split()))
def ma():
    return map(int,input().split())
t=1
while(t):
    t-=1
    s=st()
    dd={}
    for i in range(len(s)-9):
        x=s[i:i+10]
        da=x[:2]
        mo=x[3:5]
        fl=0
        ye=x[6:10]
        if(x[2]!='-' or x[5]!='-'):
            continue
        try:
            if(ye in ['2013','2014','2015']):
                fl+=1
            if(int(mo)>=1 and int(mo)<=12):
                fl+=1
            cc=int(mo)
            if(cc in [1,3,5,7,8,10,12]):
                if(int(da)>=1 and int(da)<=31):
                    fl+=1
            elif(cc in [4,6,9,11]):
                if(int(da)>=1 and int(da)<=30):
                    fl+=1
            elif( cc==2):
                if(int(da)>=1 and int(da)<=28):
                    fl+=1
            if(fl==3):
                try:
                    dd[x]+=1
                except:
                    dd[x]=1
                    pass
        except:
            pass
    z=max(dd.values())
    for i in dd.keys():
        if(dd[i]==z):
            print(i)
            break
        
        
                
        
    
    
    
