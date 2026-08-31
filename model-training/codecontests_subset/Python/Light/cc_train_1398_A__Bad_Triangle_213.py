t=int(input())
for _ in range(t):
    flag=0
    n=int(input())
    inp=list(map(int,input().split()))
    if inp[0]+inp[1]<=inp[-1]:
        print (1,end=" ")
        print (2,end=" ")
        print (len(inp))
        continue
    else:
        print (-1)