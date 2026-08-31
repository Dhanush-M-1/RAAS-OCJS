for _ in range(int(input())):
    n,m = map(int,input().split())
    li1 = [int(z) for z in input().split()]
    li2 = [int(z) for z in input().split()]
    li1 = list(set(li1))
    li2 = list(set(li2))
    n = len(li1)
    m = len(li2)
    f=0
    if n>m:
        for i in li2:
            if i in li1:
                print('YES')
                print(1,i)
                f=1
                break
        if f==0:
            print('NO')
    else:
        for i in li1:
            if i in li2:
                print('YES')
                print(1,i)
                f=1
                break
        if f==0:
            print('NO')