n = int(input())
for _ in range(n):
    l,r,d = map(int,input().split())
    if(d<l):
        print(d)
    else:
        k = (r%d==0) and d or d-r%d
        print(r+k)