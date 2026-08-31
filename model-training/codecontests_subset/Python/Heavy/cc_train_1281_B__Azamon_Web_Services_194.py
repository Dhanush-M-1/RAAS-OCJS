import sys 
input=sys.stdin.readline 
t=int(input())
for i in range(t): 
    a,b=input().split()
    a=a.strip()
    b=b.strip() 
    if a<b:
        print(a)
        continue 
    n=len(a)
    m=len(b)
    a=list(a)
    f=0 
    b=list(b)
    for i in range(min(n,m)):
        if f:
            break 
        if a[i]==b[i]:
            for j in range(i+1,n):
                if a[j]<b[i]:
                    a[j],a[i]=a[i],a[j]
                    f=1 
                    break 
        elif a[i]>b[i]:
            curr=b[i]
            for j in range(i+1,n):
                if a[j]<b[i]:
                    a[j],a[i]=a[i],a[j]
                    f=1
                    break 
            break 
    if f:
      #  print('df')
        print(''.join(a))
        continue 
    for i in range(min(n,m)):
        if f:
            break 
        if a[i]==b[i]:
            continue 
        for j in range(n-1,i,-1):
            if a[j]<=b[i]:
                a[j],a[i]=a[i],a[j]
                f=1 
                break 
    if f:
        if a<b:
            print(''.join(a))
        else:
            print('---')
    else:
        print('---')