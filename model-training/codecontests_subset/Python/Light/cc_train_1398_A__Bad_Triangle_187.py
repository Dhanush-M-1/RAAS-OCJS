import math

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    a,b = arr[0], arr[1]
    c = -1
    for i in range(2, n):
        if(arr[i]>= a+b):
            c = i+1
            break
    if(c!= -1):
        print(1,2,c)
    else:
        print(-1)
