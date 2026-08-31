from collections import deque
for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    maxi=0
    indx=0
    for i in range(n):
        if(maxi<a[i]):
            maxi=a[i]
            indx=i
    visited=[0 for i in range(n+1)]
    queue=deque()
    queue.append([maxi,indx])
    visited[indx]=1
    stored=[0 for i in range(n+1)]
    while queue:
        q,idx=queue.popleft()
        visited[idx]=1
        maxi=0
        indx=idx
        indx-=1
        indxe=0
        while(indx>=0 and visited[indx]==0):
            if(maxi<a[indx]):
                maxi=max(maxi,a[indx])
                indxe=indx
            indx-=1
        if(maxi>0):
            queue.append([maxi,indxe])
            stored[maxi]=stored[q]+1
        maxi=0
        indx=idx
        indx+=1
        while(indx<n and visited[indx]==0):
            if(maxi<a[indx]):
                maxi=max(maxi,a[indx])
                indxe=indx
            indx+=1
        if(maxi>0):
            queue.append([maxi,indxe])
            stored[maxi]=stored[q]+1
    for i in range(n):
        print(stored[a[i]],end=' ')
    print()

