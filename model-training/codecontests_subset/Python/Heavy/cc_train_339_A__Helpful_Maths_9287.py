from collections import Counter
import string
import math
import sys
def array_int():
    return [int(i) for i in sys.stdin.readline().split()]
def vary(number_of_variables):
    if number_of_variables==1:
        return int(sys.stdin.readline())
    if number_of_variables>=2:
        return map(int,sys.stdin.readline().split()) 
def makedict(var):
    return dict(Counter(var))
mod=100000007
num=input()
b=[]
for i in num:
    if i!='+':
        b.append(int(i))
b.sort()
ans=''
for i in range(len(b)):
    ans+=str(b[i])
    ans+='+'
print(ans[:-1])
                

                 

            
    

















        






        


        



