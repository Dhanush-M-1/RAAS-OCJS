t = int(input())
for i in range(t):
    n = int(input())
    data = list(map(int , input().split()))
    if data[0] + data[1] <= data[-1]:
        print(1,2,n)
    else:
        print(-1)