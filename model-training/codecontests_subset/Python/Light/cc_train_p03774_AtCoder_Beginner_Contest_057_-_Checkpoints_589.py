a,b=map(int,input().split())
p=[list(map(int,input().split()))for i in range(a)]
q=[list(map(int,input().split()))for i in range(b)]
for i in range(a):
    r=[]
    for j in range(b):
        r.append([abs(p[i][0]-q[j][0])+abs(p[i][1]-q[j][1]),j+1])
    else:
        r.sort()
        print(r[0][1])