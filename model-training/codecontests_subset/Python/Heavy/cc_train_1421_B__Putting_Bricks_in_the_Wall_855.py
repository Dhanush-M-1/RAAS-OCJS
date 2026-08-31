t = int(input())
while t:
    mas=[]
    n = int(input())
    for i in range(n):
        w = input()
        w = list(w)
        mas.append(w)

    s1 = int(mas[0][1])
    s2 = int(mas[1][0])
    f1 = int(mas[-2][-1])
    f2 = int(mas[-1][-2])

    if s1 == s2 and f1==f2 and f1!=s1:#
        print(0)
        t-=1
        continue
    if s1 != s2 and f1==f2:
        if s1 == f2:
            print(1)
            print(1,2)
            t-=1
            continue
        else:
            print(1)
            print(2,1)
            t-=1
            continue
    if f1!=f2 and s1==s2:#
        if f1==s1:
            print(1)
            print(n-1,n)
            t-=1
            continue
        else:
            print(1)
            print(n,n-1)
            t-=1
            continue
    if s1==s2 and f1==f2 and s1==f1:#
        print(2)
        print(1,2)
        print(2,1)
        t-=1
        continue
    if f1!=f2 and s1!=s2 and s1==f1:
        print(2)
        print(1,2)
        print(n,n-1)
        t-=1
        continue
    if f1!=f2 and s1!=s2 and s1!=f1:
        print(2)
        print(1,2)
        print(n-1,n)
        t-=1
        continue