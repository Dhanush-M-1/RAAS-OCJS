from sys import *
from bisect import *
from collections import *
from itertools import *
from fractions import *

Input = []

#stdin = open('in', 'r')
#stdout = open('out', 'w')

## for i, val in enumerate(array, start_i_value)

def Out(x):
    stdout.write(str(x) + '\n')

def In():
    return stdin.readline().strip()

def inputGrab():
    for line in stdin:
        Input.extend(map(str, line.strip().split()))
'''--------------------------------------------------------------------------------'''

ans = dict()

def dateConv(dd, mm, yy):
    dds = str()
    if(dd < 10):
        dds = '0'+str(dd)
    else:
        dds = str(dd)
    mms = str()
    if(mm < 10):
        mms = '0'+str(mm)
    else:
        mms = str(mm)
    return dds+'-'+mms+'-'+str(yy)
    

def main():
    s = In()
    
    Date = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    MaxCnt = 0
    ans = str()
    
    
    for mm in range(1, 13):
        for dd in range(1, Date[mm-1]+1):
            for yy in range(2013, 2016):
                #print("Search for", dateConv(dd, mm, yy))
                
                cnt = s.count(dateConv(dd, mm, yy))
                if cnt > MaxCnt:
                    ans = dateConv(dd, mm, yy)
                    MaxCnt = cnt
    
    print(ans)
    
if __name__ == '__main__':
    main()
