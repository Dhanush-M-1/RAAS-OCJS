for _ in range(int(input())):
    n=int(input())
    list1=[int(x) for x in input().split()]

    val1=list1[0]+list1[1]
    if val1<=list1[n-1]:
        print(1,2,n)
    else:
        print(-1)
