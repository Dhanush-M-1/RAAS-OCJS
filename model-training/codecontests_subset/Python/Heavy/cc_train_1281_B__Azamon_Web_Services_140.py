


for i in range(int(input())):


    a,b = input().split()
    a=list(a)
    b=list(b)


    if a<b:
        print(''.join(a))
    else:


        A=list(sorted(a))

        for i in range(len(a)):

            if A[i]!=a[i]:
                re=-1
                for k in range(i,len(a)):
                    if a[k]==A[i]:
                        re=max(k,re)

                a[i],a[re]=a[re],a[i]
                break

        if a<b:
            print(''.join(a))
        else:
            print('---')
