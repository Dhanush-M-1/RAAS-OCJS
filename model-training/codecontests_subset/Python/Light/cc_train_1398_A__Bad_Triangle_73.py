# cook your dish here
for _ in range(int(input())):
    k = int(input())
    l = list(map(int,input().split()))
    a = 0
    v = l[0]+l[1]
    for i in range(2,len(l)):
        if v<=l[i]:
            z = i+1
            a = 1
            break
    if a == 1:
        print(1,2,z)
    else:
        print(-1)