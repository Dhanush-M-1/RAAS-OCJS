for i in range(0,int(input())):
    n=int(input())
    list1 = list(map(int,input().strip().split()))[:n]
    if list1[0]+list1[1]<=list1[n-1]:
        print(1,2,n)
    else:
        print(-1)    
