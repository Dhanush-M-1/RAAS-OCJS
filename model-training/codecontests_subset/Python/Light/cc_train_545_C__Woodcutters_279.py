n=int(input())
a=[[int(x) for x in input().split()]for i in range(n)]
if n==1:
    sum1=1
else:
    sum1=2
    test=a[0][0]
    for j in range(1,len(a)-1):
        if a[j][0]-a[j][1]>test:#向左倒
            sum1+=1
            test=a[j][0]
        elif a[j][0]+a[j][1]<a[j+1][0]:#向右倒
            sum1+=1
            test=a[j][0]+a[j][1]
        else:
            test=a[j][0]
print(sum1)
