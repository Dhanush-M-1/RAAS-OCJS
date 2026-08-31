for _ in range(int(input())):
    n,m = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    a.sort()
    b.sort()
    ap = 0
    bp = 0
    found = False
    while ap<n and bp<m:
        if a[ap]==b[bp]:
            found = True
            el = a[ap]
            break
        elif a[ap]<b[bp]:
            ap+=1
        elif a[ap]>b[bp]:
            bp+=1
    if found:
        print("YES")
        print(1,el,sep=" ")
    else:
        print("NO")