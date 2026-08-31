def Frequency(arr):
    dic={}
    for i in range(len(arr)):
        dic[arr[i]]=0
    for i in range(len(arr)):
        dic[arr[i]]+=1
    return dic
    
k=int(input())
s=list(input())
freq=Frequency(s)
flag=1
for key,value in freq.items():
    if(value%k!=0):
        flag=0
        break
    else:
        freq[key]=value//k
if(flag==0):
    print(-1)
else:
    for i in range(k):
        for key,value in freq.items():
            for _ in range(value):
                print(key,end="")
            
