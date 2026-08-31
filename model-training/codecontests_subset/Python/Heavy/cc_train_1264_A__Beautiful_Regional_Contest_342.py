t=int(input())
for i in range(t):
    n=int(input())
    plist=[int(x) for x in input().split(' ')]
    if n <= 5:
        print(0,0,0,sep=' ')
    else:
        for k in range(n):
            if plist[0] != plist[k]:
                break
        a=k
        b=0
        c=0
        while (b <= a) and a+b+c <= n/2:
            for j in range(k+1,n):
                if plist[k] != plist[j]:
                    break
            x=j
            b=b+(x-k)
            k=x
        if b <= a:
            print(0,0,0,sep=' ')
        else:
            while a+b+c < n/2:
                for j in range(k,n):
                    if plist[k] != plist[j]:
                        break
                if a+b+c+j-k>n/2:
                    break
                else:
                    c+=(j-k)
                    k=j
            if c > a:
                print(a,b,c,sep=' ')
            else:
                print(0,0,0,sep=' ')
