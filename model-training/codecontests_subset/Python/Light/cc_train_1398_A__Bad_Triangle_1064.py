for _ in range(int(input())):
    inp = input()
    y = list(map(int,input().split()))
    if y[0]+y[1] <= y[-1]:
        print(1,2,len(y))
    else:
        print(-1)