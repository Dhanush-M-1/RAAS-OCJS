t = int(input())

for k in range(t):
    n = int(input())
    arr = []
    for i in range(n):
        p,c = map(int,input().rstrip().split())
        arr.append([p,c])
    p,c = arr[0][0],arr[0][1]

    count = True
    if(p<c):
        print("NO")
        count=False
    else:
        for i in range(1,n):
            k,m = arr[i][0],arr[i][1]

            if(k<p or m<c or k<m or (k-p)<(m-c)):
                print("NO")
                count = False
                break
            p,c = k,m

    if(count==True):
        print("YES")