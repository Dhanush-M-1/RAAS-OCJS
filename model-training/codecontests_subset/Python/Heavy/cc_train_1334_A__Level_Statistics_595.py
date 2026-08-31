def stats(n,array):
    cp=0
    cc=0
    for i in range(n):
        if array[i][0]-cp>=array[i][1]-cc:
            if i>0:
                if array[i][0]<array[i-1][0] or array[i][1]<array[i-1][1]:
                    print("NO")
                    return
            cp=array[i][0]
            cc=array[i][1]
            continue
        else:
            print("NO")
            return 
    print("YES")
    return

t=int(input())
array=[]
for j in range(t):
    peeks=int(input())
    arrayc=[]
    for k in range(peeks):
        arrayc.append(list(map(int,input().split(" "))))
    array.append([peeks,arrayc])
for x in array:
    stats(*x)