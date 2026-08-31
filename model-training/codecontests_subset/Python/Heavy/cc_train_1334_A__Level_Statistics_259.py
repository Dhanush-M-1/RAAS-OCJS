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
for _ in range(vary(1)):
    plays=[]
    clears=[]
    for i in range(vary(1)):
        p,c=vary(2)
        plays.append(p)
        clears.append(c)
    sump=clearp=0
    for i in range(len(plays)):
        if plays[i]<clears[i]:
            print('NO')
            break
        try:
            if plays[i]>plays[i+1] or clears[i]>clears[i+1]:
                print('NO')
                break
            t=plays[i+1]-plays[i]
            if clears[i+1]-clears[i]>t:
                print('NO')
                break
        except:
            pass
    else:
        print('YES')



    


    






        






        


        



