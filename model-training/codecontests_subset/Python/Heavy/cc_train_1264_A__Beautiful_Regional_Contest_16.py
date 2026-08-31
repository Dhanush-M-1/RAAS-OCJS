for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    if n<6:
        print(0,0,0)
    else:
        g,s,b = 1,0,0
        # give gold medals
        i = 1
        while i<n//2 and a[i]==a[i-1]:
            g+=1
            i+=1
        if i>=n//2:
            print(0,0,0)
            continue
        s = 1
        i+=1
        while i<n//2 and (a[i]==a[i-1] or s<=g):
            s+=1
            i+=1
        if i>=n//2:
            print(0,0,0)
        else:
            start = i
            i = n//2
            i-=1
            b = n//2-(g+s)
            while a[i]==a[i+1]:
                b-=1
                i-=1
            if g<s and g<b and g>0 and b>0 and s>0 and g+s+b<=n//2:
                print(g,s,b)
            else:
                print(0,0,0)