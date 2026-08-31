for i in range(int(input())):
    N=int(input())
    side_array=list(map(int,input().split()))
    for i in range(2,N):
        if side_array[0]+side_array[1]<=side_array[i]:
            flag=1
            d=i
            break
        else:
            flag=0
    if flag==1:
        print(1,2,d+1)
    else:
        print(-1)