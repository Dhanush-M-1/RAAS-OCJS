if __name__=='__main__':
    t=int(input())
    for i in range(t):
        n=int(input())
        l=[]
        for i in range(n):
            p,c=map(int,input().strip().split())
            l.append([p,c])
        diff1=0
        diff2=0
        f=0
        for i in range(1,n):
            diff1=l[i][0]-l[i-1][0]
            diff2=l[i][1]-l[i-1][1]
            if diff1<0 or diff2<0:
                f=1
                break
            if diff1<diff2:
                f=1
                break
            if l[i][0]<l[i][1] or l[i-1][0]<l[i-1][1]:
                f=1
                break
        if l[0][0]<l[0][1]:
            print('NO')
        elif f==1:
            print('NO')
        else:
            print('YES')
