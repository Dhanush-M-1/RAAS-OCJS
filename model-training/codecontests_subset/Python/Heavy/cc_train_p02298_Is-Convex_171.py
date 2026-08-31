def vc(p,q):
    return[p[0]-q[0],p[1]-q[1]]

def cross(u,v):
    return(u[0]*v[1]-u[1]*v[0])

n = int(input())
v = []
for _ in range(n):
    x0,y0 = map(int,input().split())
    v.append([x0,y0])
flag = True
for i in range(n-2):
    e_i = vc(v[i+1],v[i])
    e_nxt = vc(v[i+2],v[i+1])
    if cross(e_i,e_nxt)<0:
        flag = False
e_i = vc(v[-1],v[-2])
e_nxt = vc(v[0],v[-1])
if cross(e_i,e_nxt)<0:
    flag = False
e_i = vc(v[0],v[-1])
e_nxt = vc(v[1],v[0])
if cross(e_i,e_nxt)<0:
    flag = False
if flag:
    print(1)
else:
    print(0)
        
    

