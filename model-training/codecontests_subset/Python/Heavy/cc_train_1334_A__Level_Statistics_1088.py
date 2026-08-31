t=int(input())
for _ in range(t):
    n=int(input())
    pl=[]
    cl=[]
    for i in range(n):
        p,c=map(int,input().split())
        pl.append(p)
        cl.append(c)
    flag=0
    for i in range(0,n):
        if i==0:
            if pl[i]<cl[i]:
                flag=1
                break
        else:
            if pl[i] < pl[i - 1] or cl[i] < cl[i - 1]:
                flag = 1
                break
            elif pl[i] - pl[i - 1] < cl[i] - cl[i - 1]:
                flag = 1
                break
    if flag==1:
        print("NO")
    else:
        print("YES")