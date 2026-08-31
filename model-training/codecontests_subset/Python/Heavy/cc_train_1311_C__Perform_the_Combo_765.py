def main(n,m,s,p):
    count=[0]*(26)
    p.append(n)
    log=[0]*n
    c=0
    m=m+1
    for i in range(m):
        log[p[i]-1]+=1
    
    for i in range(n):
        if log[i]>0:
            c+=log[i]
            temp=m-c+log[i]
            log[i]=temp
            continue
        log[i]=m-c
    
    for i in range(n):
            count[ord(s[i])-97]+=log[i]
        
    return count

k=int(input())
for _ in range(k):
    n,m=map(int,(input().split()))
    s=input()
    p=list(map(int,input().split()))
    res=(main(n,m,s,p))
    print(*res, sep=' ')