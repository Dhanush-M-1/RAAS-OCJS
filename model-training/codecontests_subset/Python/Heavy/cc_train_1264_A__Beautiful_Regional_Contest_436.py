def answer(n,A):
    if n<10:
        return [0,0,0]
    flag=0
    if A[n//2-1]==A[n//2]:
        flag=1
    d={}
    for i in range(n//2):
        if flag:
            if A[i]==A[n//2]:
                break
        if A[i] in d:
            d[A[i]]+=1
        else:
            d[A[i]]=1
    
    if len(d)<3:
        return [0,0,0]
    g=0
    s=0
    b=0
    flag=1
    for i in d:
        if flag:
            g=d[i]
            flag=0
        else:
            if s<=g:
                s+=d[i]
            else:
                b+=d[i]
                
    if g<s and g<b:
        return [g,s,b]
    return [0,0,0]

t=int(input())
for i in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    print(*answer(n,arr))   