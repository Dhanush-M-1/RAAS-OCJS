t = int(input())
for _ in range(t):
    n = int(input())
    l1 = [int(x) for x in input().split()]
    flag = 0
    if l1[0]+l1[1]<=l1[-1]:
        flag = 1
    
    if flag:
        print(1,2,n)
    else:
        print(-1)