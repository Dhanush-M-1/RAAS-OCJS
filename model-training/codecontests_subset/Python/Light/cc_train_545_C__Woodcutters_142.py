
n=int(input())
l=[]
for i in range(n):
    l+=[list(map(int,input().split()))]
c=2
s=l[0][0]
for i in range(1,n-1):
    S=l[i]
    T=l[i+1]
    if S[0]-s>S[1]:
        c+=1
        s=S[0]
        continue
    if S[0]+S[1]<T[0]:
        c+=1
        s=S[0]+S[1]
        continue
    s=S[0]
if n<2:
    print(n)
else:
    print(c)
