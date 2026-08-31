for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    medals = n//2
    g = 0
    s=0
    b=0

    m = {}
    for elem in a:
        m[elem] = 1+m.get(elem,0)

    freq = []
    count = 0
    for elem in m:
        count+=m[elem]
        freq.append(count)


    st=0
    e=len(freq)-1
    ans = 0
    while st<=e:
        mid = (st+e)//2
        if freq[mid]<=medals:
            ans=freq[mid]
            st=mid+1
        elif freq[mid]>medals:
            e=mid-1
    g = m[a[0]]
    ans-=g

    if ans>0:
        for elem in m:
            if elem!=a[0]:
                s+=m[elem]
                if s>g:
                    break
        ans-=s
        if ans>0:
            b= ans
            if b>g:
                print(g,s,b)
            else:
                print(0,0,0)

        else:
            print(0,0,0)
    else:
        print(0,0,0)
