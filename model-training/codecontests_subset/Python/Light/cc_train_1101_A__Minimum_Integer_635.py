n=int(input())
for i in range(0,n):
    lrd=input().split()
    l=int(lrd[0])
    r=int(lrd[1])
    d=int(lrd[2])
    if d<l:
        print(d)
    else:
        print(r+(d-(r%d)))