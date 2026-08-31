def cs():
    for i in range(int(input())):
        success=0
        hasha=[0 for x in range(1001)]
        hashb=[0 for x in range(1001)]
        s1=input().split()
        (n,m)=(int(s1[0]),int(s1[1]))
        a=[int(x) for x in input().split()]
        b=[int(x) for x in input().split()]
        for j in range(n):
            hasha[a[j]]=hashb[a[j]]+1
        for r in range(m):
            hashb[b[r]]=hashb[b[r]]+1
        for k in range(1001):
            if hasha[k]>=1 and hashb[k]>=1:
                print("YES")
                print(1,k)
                success=1
                break
        if success==0:
            print("NO")

cs()

