import sys
from collections import defaultdict
def move(arr,l,num,i):
    #print(l,'l',num,'num',i,'i')
    '''if 1 in l:
        print('aaa')'''
    #count=0
    for j in range(i,n-1):
        if arr[j+1] in l:
            arr[j+1],arr[j]=arr[j],arr[j+1]
        else:
            return 
    '''for j in range(i,0,-1):
        if arr[j-1] in l:
            #print('a')
            arr[j-1],arr[j]=arr[j],arr[j-1]
            count+=1
        else:
            break
    return count'''
n,m=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
graph=defaultdict(set)
graph1=defaultdict(set)
vis=defaultdict(int)
for i in range(m):
    u,v=map(int,sys.stdin.readline().split())
    graph[v].add(u)
    graph1[u].add(v)
for i in graph[arr[n-1]]:
    vis[i]=1
#print(vis,'vis')
#print(graph,'graph')
#print(graph1,'graph1')
#print(arr,'arr')
num=arr[n-1]
for i in range(n-1,-1,-1):
    
        #print(arr,'before')
        move(arr,graph1[arr[i]],arr[i],i)
        #print(arr,'after')
for i in range(n):
    if arr[i]==num:
        break
print(n-1-i)
#print(arr,'before final')
#x=move(arr,graph[arr[n-1]],arr[n-1],n-1)
#print(arr,'before after')
#print(x)
