w=int(input())
a=[]
for i in range(w):
    t=input()
    p=input().split()
    a.append(p)
for i in range(w):
    o=0
    r=a[i]
    for j in range(2,len(r)):
        if int(r[0])+int(r[1])<=int(r[j]):
            o = j+1
    if o>=3:
        print(*[1,2,o])
    else:
        print(-1)
