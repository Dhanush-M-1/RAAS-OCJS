from sys import *
input = stdin.readline
output = stdout.write

for _ in range(int(input())):
    
    n = int(input())
    a = list(map(int,input().split()))
    
    ind = -1
    sn = a[0]+a[1]
    
    for i in range(2,n):
        if(a[i]>=sn):
            ind = i
            break
            
            
    if(ind == -1):
        output(str(-1)+'\n')
    else:
        output(str(1)+' '+str(2)+' '+str(ind+1)+'\n')
    
    
