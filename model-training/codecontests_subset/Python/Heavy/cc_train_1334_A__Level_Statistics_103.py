for _ in range(int(input())):
    n=int(input())
    plays=[]
    clears=[]
    flag=1
    for i in range(n):
        a,b=input().split()
        if(int(a)<int(b)):
            flag=0
        plays.append(int(a))
        clears.append(int(b))
    # print(plays,clears)
    # print(sorted(plays)==plays,sorted(clears)==clears,flag)
    if(flag and sorted(plays)==plays and sorted(clears)==clears):
        plays=sorted(plays)
        clears=sorted(clears)
        flag2=1
        for i in range(1,n):
            if not (plays[i]-plays[i-1]>=clears[i]-clears[i-1]):
                print('NO')
                flag2=0
                break
        if(flag2):
            print('YES')
    else:
        print('NO')
