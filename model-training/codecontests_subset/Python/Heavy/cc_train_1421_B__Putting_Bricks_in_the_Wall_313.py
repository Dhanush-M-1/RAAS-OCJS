# cook your dish here
for _ in range(int(input())):
    n=int(input())
    a=[]
    for i in range(n):
        a.append(input())
    l=[]
    if a[0][1]==a[1][0]:
        if a[-2][-1]==a[0][1]:
            l.append([n-1,n])
        if a[-1][-2]==a[0][1]:
            l.append([n,n-1])
    else:
        if a[-1][-2]==a[-2][-1]:
            if a[0][1]==a[-1][-2]:
                l.append([1,2])
            else:
                l.append([2,1])
        else:
            l.append([1,2])
            if a[0][1]==a[-1][-2]:
                l.append([n-1,n])
            else:
                l.append([n,n-1])
    print(len(l))
    for x in l:
        print(*x)
    