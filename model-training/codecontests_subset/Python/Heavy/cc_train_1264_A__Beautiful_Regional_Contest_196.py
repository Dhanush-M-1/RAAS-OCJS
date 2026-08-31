import sys;
import math;
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()

t = int(input());
for test in range(t):
    n = int(input());
    arr = get_array();
    g = 0;s = 0;b = 0;
    farr = [1];
    ptr = 0;
    for i in range(1,n):
        if(arr[i]==arr[i-1]):
            farr[ptr]+=1;
        else:
            farr.append(1);
            ptr+=1;
    if(len(farr)<2):
        print("0 0 0");
        continue;
    g = farr[0];
    ptr = 1;
    for i in range(ptr,len(farr)):
        if(s>g):
            break;
        else:
            s+=farr[i];
            ptr+=1;
    for i in range(ptr,len(farr)):
        if(b>g):
            break;
        else:
            b+=farr[i];
            ptr+=1;
    for i in range(ptr,len(farr)):
        if(g+s+b+farr[i]<=n//2):
            b+=farr[i];
        else:
            break;
            
    if(g+s+b>n//2 or min(g,s,b)==0):
        print("0 0 0");
        continue;
    else:
        print(g,s,b);
    
