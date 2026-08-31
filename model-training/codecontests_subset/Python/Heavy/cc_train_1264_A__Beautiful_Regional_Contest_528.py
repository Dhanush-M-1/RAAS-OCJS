from sys import stdin,stdout
cases =int(stdin.readline().strip())
for caso in range(cases):
    n=int(stdin.readline().strip())
    s=list(map(int,stdin.readline().strip().split()))
    mid=n//2
    g=-1
    s1=-1
    b=-1
    for i in range(1,n):
        if s[i]!=s[i-1]:
            g=i
            break
    lim=max(1,g)
    for i in range(lim,n):
        if s[i]!=s[i-1] and  i>2*lim:
            s1=i-lim
            lim=i
            break
    lim=max(3,lim)
    for i in range(lim,mid+1):
        if s[i]!=s[i-1] and  (i-g-s1)>g :
            b=i-g-s1
    if g==-1 or s1==-1 or b==-1:
        stdout.write("0 0 0\n")
    else:
        stdout.write("%d %d %d\n" % (g,s1,b))
        
