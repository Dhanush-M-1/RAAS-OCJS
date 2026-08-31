import sys
from collections import defaultdict
n=int(sys.stdin.readline())
arr=list(map(int,sys.stdin.readline().split()))
l=[i for i in arr]
for i in range(n):
    arr[i]=[arr[i],-i]
arr.sort()
dic=defaultdict(list)
'''for i in range(1,n+1):
    dic[i]=dic[i-1]+[-arr[n-i][1]]
    dic[i].sort()'''
#print(dic,'dic')
z=len(arr)
m=int(sys.stdin.readline())
for _ in range(m):
    n,pos=map(int,sys.stdin.readline().split())
    if dic[n]!=[]:
        #n,pos=map(int,sys.stdin.readline().split())
        print(l[dic[n][pos-1]])
    else:
        
        dic[n]=[0 for _ in range(n)]
        ind=n-1
        #print(n,'n',z-1,'start',z-n-1,'end')
        for i in range(z-1,z-n-1,-1):
            dic[n][ind]=-arr[i][1]
            ind-=1
        dic[n].sort()
        print(l[dic[n][pos-1]])
