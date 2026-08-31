a = int(input())
for x in range(a):
    b = int(input())
    c = list(map(int,input().split()))
    c.sort()
    if c[0]+c[1] > c[b-1]:
        print(-1)
    else:
        print(1,2,b)