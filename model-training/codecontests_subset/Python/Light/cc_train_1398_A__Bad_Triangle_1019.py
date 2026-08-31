# import sys
# sys.stdin = open('CF_E93_D2/input.txt', 'r') 
# sys.stdout = open('CF_E93_D2/output.txt', 'w')
#----------------------------------------------------------------

for _ in range(int(input())) :
    n = int(input())
    l = list(map(int,input().split()))
    i = 1
    if not (l[i-1]+l[i]>l[-1] and l[i]+l[-1]>l[i] and l[-1]+l[i-1]>l[i]) :
        print(1,2,n)
    else :
        print(-1)
    
    