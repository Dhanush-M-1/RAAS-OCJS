test=int(input())
for _ in range(test):
    n=int(input())
    list1=list(map(int,input().split()))
    if list1[0]+list1[1]<=list1[n-1]:
        print(1,2,n)
    else:
        print("-1")