from collections import deque

x,y,x2,y2=map(int,input().split())
n=int(input())
kletki={}
for i in range(n):
    r,a,b=map(int,input().split())    
    for j in range(a, b+1):
        kletki[(r,j)]=-1

kletki[(x,y)]=0
deq = deque()
deq.append((x,y))

dx=[-1, -1, 0, 1, 1, 1, 0, -1]
dy=[0, -1, -1, -1, 0, 1, 1, 1]
while len(deq):
    m = deq.popleft()

    for k in range(8):
        n = (m[0]+dx[k], m[1]+dy[k]) 
        if n in kletki.keys():       
            if m in kletki and kletki[n] == -1:
                kletki[n] = kletki[m]+1
                deq.append(n)
   
print(kletki[(x2,y2)])                
