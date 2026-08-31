from collections import OrderedDict
n=int(input())
for x in range(n):
    a=int(input())
    array=list(map(int,input().split()))
    limit=int(a//2)
    vie=5
    unique=len(set(array[0:limit]))
    if len(array)==1:
        print(0,0,0)
    elif unique<3:
        print(0,0,0)
    else:
        if array[limit-1]==array[limit]:            
            array=array[0:limit]
            target=array[limit-1]
            while 6==6:
                if array[-1]==target:
                    array.pop()
                else:
                    break
            unique=len(set(array[0:limit]))
        else:
            unique=len(set(array[0:limit]))
            array=array[0:limit]
        dic=OrderedDict()
        count=1
        flag=5
        for x in range(len(array)-1):
            if array[x]==array[x+1]:
               count+=1 
               flag=5
            else:
                dic[array[x]]=count
                count=1
                flag=6
        if flag==5:
            dic[array[-1]]=count
        else:
            dic[array[-1]]=1
        flag=5
        bronze=0
        silver=0
        for it in dic:
            if flag==5:
               gold=dic[it]
               flag=6
            elif flag==6:
               silver+=dic[it]
               if silver>gold:
                  flag=7
            elif flag==7:
               bronze+=dic[it]
            else:
                pass
        if gold>=silver or gold>=bronze:
            print(0,0,0)
        else:
            print(gold,silver,bronze)
               