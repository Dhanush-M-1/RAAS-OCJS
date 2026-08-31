t = int(input())
for z in range(t):
    n = int(input())
    li = list(map(int,input().split()))
    first = li[0]+li[1]
    last = max(li)
    if last>=first:
        print(1,2,n)
    else:
        print(-1)