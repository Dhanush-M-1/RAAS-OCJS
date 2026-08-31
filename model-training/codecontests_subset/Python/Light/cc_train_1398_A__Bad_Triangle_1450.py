for _ in range(int(input())):
    n = int(input())
    list1 = [int(i) for i in input().split()]
    try:
        if list1[0]+list1[1]<=list1[-1]:
            print(1,2,n)
        else:
            print(-1)
    except:
        print(-1)