

x0,y0,x1,y1 = map(int,input().split())
m = dict()
for _ in range(int(input())):
    r,a,b = map(int,input().split())
    for i in range(a,b+1):
        m[(r,i)] = -1
m[(x0,y0)] = 0
q = [(x0,y0)]



dx = [-1,1,0,0,-1,1,-1,1]
dy = [0,0,1,-1,-1,1,1,-1]

while len(q)>0:

    
    k = q.pop(0)
    for i in range(8):
        r,c = k[0]+dx[i], k[1]+dy[i]
        if (r,c) in m.keys() and m[(r,c)]==-1:
            q.append((r,c))
            m[(r,c)] = m[(k[0],k[1])] +1
            
            

print(m[(x1,y1)])
        
