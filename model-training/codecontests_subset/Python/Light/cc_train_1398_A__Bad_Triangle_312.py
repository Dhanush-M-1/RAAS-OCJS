n = int(input())
for _ in range(n):
    a = int(input())
    l = list(map(int,input().split()))
    if l[0]+l[1]<=l[a-1]:
        print(1,2,a,sep = ' ')
    else:
        print(-1)
    

