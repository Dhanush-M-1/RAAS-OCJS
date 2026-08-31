def sol(p,c,n):
    if n==1:
        if p[0]>=c[0]:
            return 'YES'
        else:
            return 'NO'   
    for i in range(n-1):
        if p[i]>=c[i] and p[i+1]>=p[i] and c[i+1]>=c[i] and p[i+1]>=c[i+1]:
            if p[i+1] >= p[i]+ (c[i+1]-c[i]):                
                continue
            else:
                return 'NO'
        else:
            return 'NO'
    return 'YES'
        

for _ in range(int(input())):
    n= int(input())
    p=[]
    c=[]
    for i in range(n):
        a,b= map(int, input().split())
        p.append(a)
        c.append(b)
    v= sol(p,c,n)
    print(v)