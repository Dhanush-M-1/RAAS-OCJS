import sys
def partition(a,low,high):
 pivot=a[high]
 i=low-1
 for j in range(low,high-1):
  if(a[j]<=pivot):
   i+=1
   temp=a[j]
   a[j]=a[i]
   a[i]=temp
  temp=a[high]
  a[high]=a[i+1]
  a[i+1]=a[high]
  return i+1
 
def quicksort(item,low,high):
 if low<high:
  pi=partition(item,low,high)
  quicksort(item,low,pi-1)
  quicksort(item,pi+1,high)

line=sys.stdin.readline()
line=line[:-1]
data=list(map(lambda x: int(x),filter(lambda x: x!='+',line)))
#quicksort(data,0,len(data)-1)
data.sort()
prstr=str(data[0])
for i in range(1,len(data)):
 prstr+="+"
 prstr+=str(data[i])
print(prstr)
