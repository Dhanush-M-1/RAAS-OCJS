def indexf(p,a):
    for i in range(len(p)-1,-1,-1):
        if p[i]==a:
            return(i)
            break
a='abcdefghijklmnopqrstuvwxyz'
n=int(input())
s=list(input())
if s==sorted(s):
    print('NO')
else:
    f=0
    print('YES')
    h=a.index(sorted(s)[n-1])
    for j in range(h,-1,-1):
        if a[j] in s:
            for i in range(0,j):
                if a[i] in s:
                    p=indexf(s,a[i])
                    if p > s.index(a[j]) :
                        print(s.index(a[j])+1,p+1)
                        f=1
                        break
        if f==1:
            break
