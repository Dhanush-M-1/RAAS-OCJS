from sys import stdin, stdout
INF=1e11
# import math
def get_int(): return int(stdin.readline().strip())
def get_ints(): return map(int,stdin.readline().strip().split()) 
def get_array(): return list(map(int,stdin.readline().strip().split()))
def get_string(): return stdin.readline().strip()
# from collections import defaultdict 
for _ in range(int(stdin.readline())):
    n=get_int()
    cnt=0
    ans=0
    while n>1:
        ans+=1
        if n%6==0:
            n=n//6
            cnt=0
        else:
            if cnt<2:
                cnt+=1
                n=n*2
            else:
                print(-1)
                break
    else:
        print(ans)
