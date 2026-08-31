def call():
    n=int(input())
    l=[int(x) for x in input().split()]
    if(l[0]+l[1]>l[-1]):
        print(-1)
    else:
        print(1,2,n)
for _ in range(int(input())):
    call()