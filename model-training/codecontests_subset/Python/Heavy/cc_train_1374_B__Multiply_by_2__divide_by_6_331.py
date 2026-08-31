import sys
input = lambda: sys.stdin.readline().rstrip()
inp = sys.stdin.buffer.readline                                
def I(): return list(map(int,inp().split()))

for _ in range(int(input())):
    n=int(input())
    n1=n
    cnt2=0 ; cnt3=0
    while n1%2==0 or n1%3==0:
        if n1%2==0:
            n1//=2
            cnt2+=1
        if n1%3==0:
            n1//=3
            cnt3+=1
    if n1 != 1: print(-1)
    else: 
        if cnt2>cnt3: print(-1)
        elif cnt2==cnt3: print(cnt2)
        else:
            print(2*cnt3-cnt2)
        
        
    