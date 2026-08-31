n,k=map(int,input().split())
list1=[]
list2=[]
list3=[]
for i in range(n):
    x,a,b=map(int,input().split())
    if(a==1 and b==1):
        list1.append(x)
    elif(a==1):
        list2.append(x)
    elif(b==1):
        list3.append(x)
        
# list1.sort()
list2.sort()
list3.sort()
for i in range(min(len(list2),len(list3))):
    list1.append(list2[i]+list3[i])
list1.sort()
l=len(list1)
if(l<k):
    print(-1)
else:
    print(sum(list1[0:k]))
# kk=0