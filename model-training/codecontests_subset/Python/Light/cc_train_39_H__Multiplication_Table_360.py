def convert(n,base):
    x=""
    while n>0:
        x+=str(n%base)
        n//=base
    return x[::-1]
def func(x,n):
    ans=[]
    ans.append(x)
    for i in range(2,n):
        ans.append(int(convert(x*i,n)))
    return ans
n=int(input())
ans=[]
for i in range(1,n):
    if i==1:
        x=[j for j in range(1,n)]
        ans.append(x)
    else:
        x=func(i,n)
        ans.append(x)
for s in ans:
    print(*s)
