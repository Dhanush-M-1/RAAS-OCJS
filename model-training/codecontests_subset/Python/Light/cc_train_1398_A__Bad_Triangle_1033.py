for i in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    sum1=l[0]+l[1]
    zero=0
    for j in range(2,n):
        if l[j]>=sum1:
            print(1,2,j+1)
            zero=1
            break
    if zero==0:
        print('-1')