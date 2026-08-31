def swapPositions(list, pos1, pos2): 
      
    list[pos1], list[pos2] = list[pos2], list[pos1] 
    return list
 
def solve(s):
    #print(ord('Z'))
    ll=[0]*26
    for i in range(len(s[0])):
        ll[ord(s[0][i])-65]+=1
    path=list()
    for i in range(26):
        if(ll[i]!=0):
            path.append(i)
    arr1=list()
    #print(path)
    for i in range(len(s[0])):
        arr1.append(s[0][i])
    #print(arr1)
    swap=-1
    ts=-1
    curr=0
    ini=path[0]
    for i in range(len(arr1)):
        #print(ini)
        if(ini==ord(arr1[i])-ord('A')):
            ll[ini]-=1
        elif(ini<ord(arr1[i])-ord('A')):
            swap=ini
            ts=i
            #print("ts=",ts)
            break
        if(ll[ini]==0):
            
            if(curr!=len(path)-1):
                curr+=1
                ini=path[curr]
    if(ts!=-1):
        swap=swap+65
        ch=chr(swap)
        #print(ch)
        for i in range(len(arr1)):
            if(arr1[i]==ch):
                ind=i
        arr1=swapPositions(arr1,ts,ind)
    #print(arr1)
    #print(arr1)
    for i in range(min(len(s[0]),len(s[1]))):
        if(arr1[i]>s[1][i]):
            print("---")
            return 
        if(arr1[i]<s[1][i]):
            for i in range(len(arr1)):
                print(arr1[i],end="")
            print()
            return 
    if(len(s[0])<len(s[1])):
        for i in range(len(arr1)):
            print(arr1[i],end="")
        print()
    else:
        print("---")
        return
    
    
        
t=int(input())
for i in range(t):
    #arr=list(map(int,input().split()))
    s=input()
    s=s.split()
    solve(s)




