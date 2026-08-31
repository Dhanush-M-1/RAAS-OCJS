x=[]
h=[]
o=2
n=int(input())
for i in range(n):
    _,__=map(int,input().split())
    x.append(_)
    h.append(__)
for i in range(1,n-1):
    if x[i]-x[i-1]>h[i]:
        o+=1
    elif x[i+1]-x[i]>h[i]:
        o+=1
        x[i]+=h[i]
print([1,o][n>1])