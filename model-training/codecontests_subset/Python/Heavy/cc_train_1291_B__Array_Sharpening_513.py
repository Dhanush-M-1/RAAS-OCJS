I = input
for _ in range(int(I())):
    try:
        n = int(I())
        a = list(map(int, I().split(' ')))
        h = n // 2
        if n % 2 == 0:
            h-=1
        i=0
        t=0
        # print(h)
        if n>2:
            while i!=h:
                # print(i)
                if a[i]<t or a[n-i-1]<t :
                    # print(i)
                    assert 1==0
                a[i]=t
                a[n-i-1]=t
                t+=1
                i+=1
            # print(i,t)
            if n%2==0:
                q=min(a[i],a[i+1])
                if q<t or(q==t and a[i+1]==a[i]):
                    assert 1==0
            else:
                if a[i]<t:
                    assert 1==0
            print('Yes')
        elif n==2:
            if a[0]==a[1]==0:
                print('No')
            else:
                print('Yes')
        else:
            print('Yes')
    except AssertionError:
        print('No')
