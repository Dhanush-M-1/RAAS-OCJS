import sys
T = int(sys.stdin.readline())
for i in range(T) :
    N = int(sys.stdin.readline())
    i = 0
    arr = list(map(int,sys.stdin.readline().split()))
    for i in range (2,N) :
        if (arr[0] + arr[1] <= arr[i]) :
            print(1,2,i+1)
            break
    else :
        print(-1)