k=int(input())
arr=[]
for i in range(3):
    arr.append(input().split())
dic=dict()
for i in arr[0]:
    if i not in dic:
        dic[i]=1
    else:
        dic[i]+=1
for i in arr[1]:
    dic[i]-=1
for i,j in dic.items():
    if j!=0:
        print(i,end=" ")
print('')
dic=dict()
for i in arr[1]:
    if i not in dic:
        dic[i]=1
    else:
        dic[i]+=1
for i in arr[2]:
    dic[i]-=1
for i,j in dic.items():
    if j!=0:
        print(i,end=" ")
print('')

#two=list(set(arr[1]).difference(set(arr[2])))
#for i in one:
#    print(i,end=" ")
#print('')
#for i in two:
#    print(i,end=" ")
#    