n=int(input())
if n==1:
    print(1)
else:
    s=[[int(x) for x in input().split()]for i in range(n)]
    s[0][1]=-s[0][1]
    for i in range(1,n-1):
        if s[i][0]-s[i][1]>max(s[i-1][0]+s[i-1][1],s[i-1][0]):
            s[i][1]=-s[i][1]
        else:
            if s[i][0]+s[i][1]>=s[i+1][0]:
                s[i][1]=0
    answer=2
    for i in range(1,n-1):
        if s[i][1]!=0:
            answer=answer+1
    print(answer)
