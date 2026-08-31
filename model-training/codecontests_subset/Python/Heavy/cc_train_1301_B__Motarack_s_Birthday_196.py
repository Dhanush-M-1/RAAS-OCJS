for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    cnt = 0
    u = -1
    for i in arr:
        if i!=-1:
            cnt+=1
            u = i
    if cnt==0:
        print(0,0)
    elif cnt==1:
        print(0,u)
    else:
        maxx = max(arr)
        m = 10**10
        for i in arr:
            if i!=-1:
                m = min(m,i)
        l,h = m,maxx
        temp = arr[::]
        for i in range(n):
            if temp[i]==-1:
                temp[i] = l
        t = -1
        for i in range(1,n):
            t = max(t,abs(temp[i]-temp[i-1]))
        val1 = t
        t = -1
        temp = arr[::]
        for i in range(n):
            if temp[i]==-1:
                temp[i] = h
        for i in range(1,n):
            t = max(t,abs(temp[i]-temp[i-1]))
        val2 = t
        while l<h:
            m = (l+h)//2
            temp = arr[::]
            for i in range(n):
                if temp[i]==-1:
                    temp[i]=m
            t = -1
            for i in range(1,n):
                t = max(t,abs(temp[i]-temp[i-1]))
            if val1>val2:
                l = m
                val1 = t
            else:
                h = m
                val2 = t
            if abs(h-l)==1:
                break
        # print(temp,arr)
        if val1<val2:
           print(val1,l)
        else:
            print(val2,h)
