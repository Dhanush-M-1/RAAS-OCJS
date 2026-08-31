def inti_dic(d,no,opertions):
 if no in d:
  a=d[no]
  if a[0]<k:#if  no less than desire k than only add opeartion
   a[0]+=1#otherwise operation would be increase
   a[1]+=op
   d[no]=a
 else:d[no]=[1,opertions]

n,k=map(int,input().split())
arr=list(map(int,input().split()))
d={}
arr=sorted(arr)
for i in arr:
 no,op=i,0
 inti_dic(d,no,op)#total opertion to make this no
 while no!=0:
   no=no//2
   op+=1
   inti_dic(d,no,op)#total opeartion to make this no
minn=10**15
for i in d:
  a=d[i]
  if a[0]>=k:minn=min(a[1],minn)
print(minn)
