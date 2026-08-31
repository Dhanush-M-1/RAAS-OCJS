for _ in range(int(input())):
    p = input()
    t,a,b = map(int,input().split(" "))
    # p = t
    arr = []
    arr.append(list(map(int,input().split(" "))))
    arr.append(list(map(int,input().split(" "))))
    ptar = []
    for x in range(a+b):
        if arr[0] and arr[0][0]<=t:
            ptar.append(arr[0][0])
            if arr[0][0]==0:
                t+=1
            arr[0].pop(0)
        elif arr[1] and arr[1][0]<=t:
            ptar.append(arr[1][0])
            if arr[1][0]==0:
                t+=1
            arr[1].pop(0)
        else:
            ptar=[-1]
            break
    print(*ptar)
            

