t=int(input())
for i in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    diff=0
    d={}
    if n>5:
        sum1=0
        for i in range(n):
            if d.get(l[i])==None:
                diff+=1
                d[l[i]]=1
            else:
                d[l[i]]+=1
            sum1+=1
            if sum1>n//2:
                sum1-=d[l[i]]
                d[l[i]]=0
                diff-=1
                break

        if diff<3:
            print("0 0 0")
        else:
            sum=0
            for i in d:
                if i==l[0]:
                    continue
                else:
                    sum+=d[i]
                if sum>d[l[0]]:
                    break
            if sum>d[l[0]] and sum1-sum-d[l[0]]>d[l[0]]:
                print(d[l[0]],sum,sum1-sum-d[l[0]])
            else:
                print("0 0 0")
    else:
        print("0 0 0")