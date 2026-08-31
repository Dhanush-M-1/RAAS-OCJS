t=int(input())
for _ in range(t):
    n=int(input())
    l=[]
    for i in range(n):
        s=str(input())
        l.append(s)
    try:
        a,b,c,d=l[0][1],l[1][0],l[n-1][n-2],l[n-2][n-1]
    except:
        print(l)
        break
    arr=[a,b,c,d]
    temp=["1","1","0","0"]
    key=["0","0","1","1"]
    tempc=0
    keyc=0
    d={}
    d[0]=[0,1]
    d[1]=[1,0]
    d[2]=[n-1,n-2]
    d[3]=[n-2,n-1]
    temparr=[]
    keyarr=[]
    
    for i in range(4):
        if(arr[i]!=temp[i]):
            tempc+=1
            temparr.append(i)
        if(arr[i]!=key[i]):
            keyc+=1
            keyarr.append(i)
    
    #print(temparr,keyarr)
    if(tempc<keyc):
        print(len(temparr))
        for j in temparr:
            print(d[j][0]+1,d[j][1]+1)
    else:
        print(len(keyarr))
        for j in keyarr:
            print(d[j][0]+1,d[j][1]+1)
                
            
