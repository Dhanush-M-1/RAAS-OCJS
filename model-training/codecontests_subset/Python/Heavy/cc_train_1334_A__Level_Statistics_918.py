t = int(input())

for tt in range(0,t):
    n = int(input())
    l=[]
    for i in range(0,n):
        a=[]
        a= list(map(int , input().split()))
        l.append(a)
    flag =0
    if l[0][0]<l[0][1]:
        print("NO")
    else:
        flag=1
        for i in range(1,n):
            if l[i][0]<l[i-1][0] or l[i][1]<l[i-1][1] or l[i][0]-l[i-1][0]<l[i][1]-l[i-1][1]:
                print("NO")
                flag=0
                break
            elif l[i][0]<l[i][1]:
                print("NO")
                flag=0
                break
            else:
                flag =1
        if flag == 1:
            print("YES")
