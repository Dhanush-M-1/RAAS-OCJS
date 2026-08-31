t=int(input())
l=[]
for i in range(t):
    n=int(input())
    s=list(map(int,input().split()))
    l.append(s)
for j in l:
    if j[0]+j[1]>j[-1]:
        print (-1)
    else:
        print(1,2,len(j))