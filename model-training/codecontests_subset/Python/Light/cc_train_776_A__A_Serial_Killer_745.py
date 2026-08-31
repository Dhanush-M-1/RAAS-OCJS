l,r=input().split()
n=int(input())
print(l,r)
for i in range(n):
    m,nxt=input().split()
    if m==l:
        l=nxt
    elif m==r:
        r=nxt
    print(l,r)
