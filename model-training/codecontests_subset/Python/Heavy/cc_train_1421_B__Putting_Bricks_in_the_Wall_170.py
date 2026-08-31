# your code goes here
for _ in range(int(input())):
    n=int(input())
    a=[[-1]*n for z in range(n)]
    for z in range(n):
        a[z]=list(input())
    ansx=[]
    if a[0][1]==a[1][0]:
        v=a[0][1]
        if a[-1][-2]==v:
            ansx.append([n,n-1])
        if a[-2][-1]==v:
            ansx.append([n-1,n])
    else:
        if a[-1][-2]==a[-2][-1]:
            v=a[-1][-2]
            if a[0][1]==v:
                ansx.append([1,2])
            if a[1][0]==v:
                ansx.append([2,1])
        else:
            v=a[0][1]
            ansx=[[2,1]]
            if a[-1][-2]==v:
                ansx.append([n,n-1])
            if a[-2][-1]==v:
                ansx.append([n-1,n])
    print(len(ansx))
    for z in ansx:
        print(*z)
