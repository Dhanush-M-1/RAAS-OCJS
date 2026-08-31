import sys;
import math;
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()

#def helper(n):
    

    

t = int(input());
for _ in range(t):
    n = int(input());
    two = 0;
    three = 0;
    while(n%2==0):
        n = n//2;
        two+=1;
    while(n%3==0):
        n = n//3;
        three+=1;
    if(n!=1):
        print(-1);
        continue;
    if(two>three):
        print(-1);
        continue;
    print((three-two)+three)
