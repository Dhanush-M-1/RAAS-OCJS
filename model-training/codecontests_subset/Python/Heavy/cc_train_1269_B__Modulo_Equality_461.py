from collections import defaultdict as dd
dic = dd(int)
n , m = map(int,input().split())
a = list(map(int , input().split()))
b = list(map(int,input().split()))


for i in b :   
    dic[i] +=1
    
#print(dic)

seti=set()

for i in range(len(b)):
    ins = b[0] - a[i]
    if ins < 0:
        seti.add(ins+m)
    else:
        seti.add(ins)
lis = list(seti)
lis.sort()

#print(lis)

for i in lis:
    dic2 = dic.copy()
    flag = 0
    for j in range(len(a)):
        if dic2[(a[j]+i)%m] !=0:
            dic2[(a[j]+i)%m] -=1
        else:
            flag = 1
            break
    if flag==1:
        continue
    else:
        print(i)
        break
            
            
        
        
        
        
        
        