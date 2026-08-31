from sys import stdin,stdout 
from bisect import bisect,bisect_left,bisect_right
def gt(): return map(int, stdin.readline().split())
def gi(): return int(stdin.readline())
def gl(): return list(map(int, stdin.readline().split())) 
def gs(): return stdin.readline()

t=gi()
for _ in range(t):
    n=gi()
    count2=0
    count3=0
    while(n%2)==0:
        n=n//2 
        count2+=1 
    while(n%3)==0:
        n=n//3 
        count3+=1
    if(n!=1 or count3<count2):
        print(-1)
        continue 
    else:
        if count2==count3:
            print(count2)
        elif count2>count3:
            print(-1)
        else:
            print(2*count3-count2)
            
        