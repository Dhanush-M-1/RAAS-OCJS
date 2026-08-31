t=int(input())
for _ in range(t):
    n=int(input())
    list1=list(int(n) for n in input().split())
    if(list1[0]+list1[1]<=list1[-1]):
        print(1,2,n)
    else:
        print(-1)