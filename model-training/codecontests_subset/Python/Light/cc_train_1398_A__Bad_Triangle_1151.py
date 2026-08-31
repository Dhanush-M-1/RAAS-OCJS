test_cases=int(input())
for test_case in range(test_cases):
    n=int(input())
    a = list(map(int, input().split()))
    sum=0
    c=0
    for i in range(n-2):
        sum=a[i]+a[i+1]
        if a[-1]>=sum:
            c=1
            break
        sum=0
    if c==0:
        print('-1')
    else:
        print(i+1,i+2,n)




