# cook your dish here
for x in range(int(input())):
    n=int(input())
    a=[int(x) for x in input().split()][:n]
    c=a[0]+a[1]
    d=0
    for x in range(2,n):
        if(c<=a[x] and n>=3):
            print('1 2',x+1)
            d=1
            break
    if(d==0):
        print('-1')