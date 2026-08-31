t=int(input())
for i in range(t):
    n=int(input())
    l=[int(i) for i in input().split()]
    print(1,2,n) if l[0]+l[1]<=l[-1] else print(-1)