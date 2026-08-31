"""n=int(input())
f=input().split(' ')
v=list()
max=0
for i in range(0,n):
    if int(f[i])>max:
        max=int(f[i])
    v.append(int(f[i]))

ans=0
#dp={i:0 for i in range(0,max+1)}
dp=dict()

for el in v:
    if el-1 not in dp:
        dp[el-1]=0
    dp[el]=dp[el-1]+1
    if dp[el]>ans:
        ans=dp[el]
        pred=el
sol=list()
i=n-1
for el in v[::-1]:
    if el==pred:
        sol.append(i+1)
        pred-=1
    i-=1
print(ans)
for i in sol[::-1]:
    print(i,end=' ')
"""

"""n=int(input())
f=input().split(' ')
f=[int(x) for x in f]

def deg3(x):
    y=0
    while x%3==0:
        y+=1
        x/=3
    return y

def comp(x,y):
    if x[0]!=y[0]:
        return x[0]>y[0]
    else:
        return x[1]<y[1]

v=[(-deg3(x),x) for x in f]
v=sorted(v)
sol=[x[1] for x in v]
for i in sol:
    print(i,end=' ')  """
"""import random

f = input().split(' ')
n = int(f[0])
k = int(f[1])
c = input().replace('\n','').split(' ')
f = [int(c[i]) for i in range(0,n)]

def quicksel(L, k):
    piv = random.choice(L)
    ls = [x for x in L if x < piv]
    eq = [x for x in L if x == piv]
    gr = [x for x in L if x > piv]
    if k <= len(ls):
        return quicksel(ls, k)
    elif k <= len(ls) + len(eq):
        return eq[0]
    else:
        return quicksel(gr, k - len(ls) - len(eq))


if k!=0:
    x = quicksel(f, k)
else:
    x = quicksel(f, 1)-1


cnt = 0
for i in f:
    if i <= x:
        cnt += 1


if (cnt != k) or x < 1 or x > 10 ** 9:
    print(-1)
else:
    print(x)"""

n=int(input())
sir=str(input())

def hashcode(s):
    return 31*(ord(s[0])-65)+ord(s[1])-65

def decode(cod):
    return (chr(cod//31+65),chr(cod%31+65))

v=dict()
maxsub=1
index=(sir[0],sir[1])
v[hashcode(index)]=1
for i in range(1,len(sir)-1):
    t=(sir[i],sir[i+1])
    cod=hashcode(t)
    if cod not in v:
        v[cod]=1
    else:
        v[cod]+=1
        if v[cod]>maxsub:
            maxsub=v[cod]
            index=decode(cod)
sol=''.join(index)
print(sol)




