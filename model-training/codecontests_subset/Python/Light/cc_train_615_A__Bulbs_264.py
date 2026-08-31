n=list(map(int,input().split()))

arr=[]
for i in range(n[0]) :
    z=list(map(int,input().split()))
    for j in range(1,len(z)) :
        if z[j] in arr :
            continue
        else :
            arr.append(z[j])

status=True
for i in range(1,n[1]+1,1) :
    if i in arr :
        continue
    else :
        status=False
        break

if status :
    print("YES")
else :
    print("NO")