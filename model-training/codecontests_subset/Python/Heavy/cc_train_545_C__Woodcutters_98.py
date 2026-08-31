pos,h=[],[]
for _ in range(int(input())):
    a,b=map(int,input().split())
    pos.append(a)
    h.append(b)
right=[]
left=[]
for i in range(len(h)):
    if i==0:
        left.append(10**10)
    else:
        left.append(pos[i]-pos[i-1])
for i in range(len(h)):
    if i==len(h)-1:
        right.append(10**10)
    else:
        right.append(pos[i+1]-pos[i])
c=0
last=0
for i in range(len(h)):
    if h[i]<left[i]:
        c+=1
    elif h[i]<right[i]:
        if i==len(h)-1:
            c+=1
        else:
            left[i+1]-=h[i]
            c+=1
print(c)