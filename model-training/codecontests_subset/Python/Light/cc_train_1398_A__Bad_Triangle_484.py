t = int(input(""))
for i in range(t):
    n = int(input(""))
    arr = input().split(" ")
    if int(arr[0])+int(arr[1])<=int(arr[-1]):
        print(1,2,n)
    else:
        print(-1)
