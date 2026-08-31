n=int(input())
for i in range(n):
    l,r,d=map(lambda x:int(x),input().split())
    dl=(l-1)//d
    dr=r//d+1
    print((dl<1 and dr*d or d))