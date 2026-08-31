import sys;import copy;
import math;
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()
 
#t = int(input());
t=1;
for test in range(t):
    a,b = get_ints();
    a2=0;a3=0;a5=0;
    b2=0;b3=0;b5=0;
    while(a%2==0):
        a2+=1;
        a=a//2;
    while(a%3==0):
        a3+=1;
        a=a//3;
    while(a%5==0):
        a5+=1;
        a=a//5;
    while(b%2==0):
        b2+=1;
        b=b//2;
    while(b%3==0):
        b3+=1;
        b=b//3;
    while(b%5==0):
        b5+=1;
        b=b//5;
    if(a!=b):
        print(-1);
        continue;
    else:
        print(abs(a2-b2)+abs(b3-a3)+abs(a5-b5));
        
