n=int(input())
for i in range(n):
        l=list(map(int,input().split()))
        if(l[0]/l[2]>1):
            print(l[2])
        else:
            n=l[1]//l[2]
            print((n+1)*l[2])