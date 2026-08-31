

test=int(input())

for t in range(0,test):
    n=int(input())
    lst=[int(x) for x in input().split()]
    if lst[n-1]>=(lst[0]+lst[1]):
        print(1,2,n)
    else :
        print(-1)