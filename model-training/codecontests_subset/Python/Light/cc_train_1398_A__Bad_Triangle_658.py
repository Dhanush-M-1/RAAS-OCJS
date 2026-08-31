def solve():
    n = int(input())
    l = [int(x) for x in input().split()]

    for i in range(2, n):
        if l[0]+l[1] <= l[i]:
            print(1,2,i+1)
            break
    else:
        print(-1)    

for _ in range(int(input())):
    solve()