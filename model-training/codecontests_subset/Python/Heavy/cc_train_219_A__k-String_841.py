k=int(input())
s=input()
m=list(s)
p=0
for i in range(97,123,1):
    c=0
    for j in range(len(m)):
        if(chr(i)==m[j]):
            c+=1
    if(c%k!=0):
        print('-1')
        p=1
        break
ans=[]
if(p!=1):
    m.sort()
    step=k
    step=int(step)
    for i in range(0,len(m),step):
        ans.append(m[i])
    if(len(ans)==len(s)):
            for j in range(len(ans)):
                print(ans[j],end='')
    else:
        for i in range(k):
            for j in range(len(ans)):
                print(ans[j],end='')