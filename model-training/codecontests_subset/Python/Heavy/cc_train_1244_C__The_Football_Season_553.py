def results(arr):
    if arr[0]*arr[2] < arr[1]:
        print (-1)
    elif arr[1] == 0:
        print (0,0,arr[0])
    elif arr[0] == arr[1] and arr[1]%arr[2]!=0 and arr[1]%arr[3]!=0:
        print(-1)
    else:
        x = max(arr[2],arr[3])
        y = arr[2] if x == arr[3] else arr[3]
        divLimit = arr[1]//x
        while 1:
            interim = arr[1] - divLimit*x
            if interim%y == 0:
                if interim//y + divLimit <= arr[0]:
                    if x == arr[2]:
                        if divLimit >=0 and interim//y >=0:
                            print (divLimit,interim//y,arr[0] - divLimit-interim//y)
                        else:
                            print (-1)
                        break
                    else:
                        if divLimit >=0 and interim//y >=0:
                            print (interim//y,divLimit,arr[0] - divLimit-interim//y)
                        else:
                            print (-1)
                        break
            else:
                divLimit -= 1 
results(list(map(int,input().split())))












