for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    flag = True
    for index in range(n-2):
        if arr[index] + arr[index+1] <= arr[-1]:
            print(index+1,index+2,n) 
            flag= False
            break
       
    if flag:
        print("-1")
