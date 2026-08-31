T = int(input())
while T>0:
    T-=1
    n = int(input())
    str1 = input()
    b = str1.split()
    a =[int(i) for i in b]
    #print(len(a),"ssss")
    flag1,flag2 = [],[]
    for i in range(0,n,1):
        if(a[i]>=i):
            flag1.append(1)
        else:
            flag1.append(0)
        if(a[i]>=n-i-1):
            flag2.append(1)
        else:
            flag2.append(0)
    for i in range(1,n,1):
        if flag1[i]==1:
            flag1[i]=flag1[i-1]
    for i in range(n-2,-1,-1):
        if flag2[i]==1:
            flag2[i]=flag2[i+1]
    f = 1
    for i in range(0,n,1):
        if flag2[i]==1 and flag1[i] == 1 and f:
            print("Yes")
            f=0
    if f :
        print("No")