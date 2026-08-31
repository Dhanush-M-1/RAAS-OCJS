INT_MAX=10**30+7
MOD=10**9+7
def INPUT():return list(int(i) for i in input().split())
def LIST_1D_ARRAY(n):return [0 for _ in range(n)]
def LIST_2D_ARRAY(m,n):return [[0 for _ in range(n)]for _ in range(m)]
#=====================================================================

for i in range(int(input())):
    n=int(input())
    x=0
    y=0
    while(n%2==0):
        n//=2
        x+=1
    while(n%3==0):
        n//=3
        y+=1
    if n==1:
        if x==0 and y==0:
            print(0)
        elif x!=0 and y==0:
            print(-1)
        elif x==0 and y!=0:
            print(2*y)
        elif x!=0 and y!=0:
            if x>y:
                print(-1)
            elif x==y:
                print(x)
            else:
                print(x+(y-x)*2)
    else:
        print(-1)
    #print()
