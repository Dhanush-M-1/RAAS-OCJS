for _ in range(int(input())):
    tab = input()
    k,n,m = map(int,input().split())
    listn = list(map(int,input().split()))
    listm = list(map(int,input().split()))
    ans = []
    status = True 
    stuck = False
    noOfTries = 0
    while(len(listm)>0 or len(listn)>0):
        if noOfTries>3:
            break
        if(len(listn)==0):
            status = False
            noOfTries+=1
        if(len(listm)==0):
            status = True
            noOfTries+=1
        if(status and listn[0]!=0):
            if(k>=listn[0]):
                ans.append(listn[0])
                listn = listn[1:]
                noOfTries = 0
            else:
                status = False
                noOfTries+=1
        elif(status and listn[0]==0):
            ans.append(listn[0])
            listn = listn[1:]
            noOfTries=0
            k+=1
        elif(not status and listm[0]!=0):
            if(k>=listm[0]):
                ans.append(listm[0])
                listm = listm[1:]
                noOfTries = 0
            else:
                status = True
                noOfTries+=1
        else:
            ans.append(listm[0])
            listm = listm[1:]
            noOfTries = 0
            k+=1
    if(noOfTries>3):
        print(-1)
    else:
        ans = list(map(str,ans))
        print(" ".join(ans))