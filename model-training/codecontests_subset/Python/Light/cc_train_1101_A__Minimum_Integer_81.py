ansarr=[]
q=int(input())
for l in range(q):
    l,r,d=map(int,input().split())
    if(l>d):
        ansarr.append(d)
    else:
        if(r%d==0):
            ansarr.append(r+d)
        else:
            val=r//d
            ansarr.append((val+1)*d)
print(*ansarr)

