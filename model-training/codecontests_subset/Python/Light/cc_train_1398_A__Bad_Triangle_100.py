# cook your dish here
t = int(input())
while t:
    n = int(input())
    l = list(map(int,input().split()))
    i = 0
    j = 1
    count = 0
    for k in range(2,n):
        if (l[k])>=(l[i]+l[j]):
            print(f'{i+1} {j+1} {k+1}')
            count = 1
            break
    if count ==0:
        print('-1')
    t-=1