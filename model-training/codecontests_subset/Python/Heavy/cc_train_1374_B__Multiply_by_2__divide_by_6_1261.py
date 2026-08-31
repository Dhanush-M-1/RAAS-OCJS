def f(x):
    # print(x)
    if x==1:
        return 0
    if x==6:
        return 1
    if x<6:
        if x==3:
            return 2
    num=str(x)
    s=0
    for i in range(len(num)):
       s+=int(num[i])
    if s%3==0:
        if x%6==0:
            temp=f(x//6)
            if temp==-1:
                return -1
            return (temp+1)
        else:
            temp=f(x*2)
            if temp==-1:
                return -1
            return (temp+1)
    else:
        return -1
for _ in range(int(input())):
    n=int(input())
    print(f(n))
