n,k=map(int,input().split())
q1=[]
q2=[]
q3=[]
for i in range(n):
    a,b,c=map(int,input().split())
    if b==1 and c==0:
        q1.append(a)
    elif b==0 and c==1:
        q2.append(a)
    elif b==1 and c==1:
        q3.append(a)
q1.sort()
q2.sort()
for i in range(min(len(q1),len(q2))):
    q3.append(q1[i]+q2[i])
if len(q3)<k:
    print(-1)
else:
    q3.sort()
    print(sum(q3[:k]))

    
            
        
