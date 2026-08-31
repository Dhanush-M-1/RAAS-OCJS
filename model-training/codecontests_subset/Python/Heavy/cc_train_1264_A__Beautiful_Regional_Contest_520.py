for _ in range(int(input())):
    n=int(input())
    a=[int(i) for i in input().split()]
    if n<10: 
        print(0,0,0)
        continue
    li=n
    n=n//2
    g,s,b=0,0,0
    for i in range(len(a)-1):
        g+=1
        if a[i]!=a[i+1]: break
    for i in range(g,n):
        s+=1
        li=i
        if a[i]!=a[i+1] and s>g: break
    if a[n]==a[n-1]:
        for i in range(n-1,-1,-1):
            if a[i]!=a[n]:
                n=i+1
                break
    for i in range(li+1,n): b+=1
    if g<s and g<b: print(g,s,b)
    else: print(0,0,0)
