
def partition(arr, low, high):
    i=low-1
    pivot=arr[high]
    for j in range (low,high):
        if arr[j]<=pivot:
            i+=1
            arr[j],arr[i]=arr[i],arr[j]
    arr[i+1],arr[high]=arr[high],arr[i+1]
    return i+1

def Quicksort(arr, low, high):
    if low<high:
        pi=partition(arr, low, high)
        Quicksort(arr, low, pi-1)
        Quicksort(arr, pi+1, high)

arr=[]
n =input()
number=len(n)
for i in range (0,number):
   if i%2==1:
       continue
   arr.append(int(n[i]))
Quicksort(arr,0,len(arr)-1)
for i in range (0,len(arr)):
    if i!=(len(arr)-1):
        print (str(arr[i]),'+',sep="", end=""),
    else:
        print (str(arr[i]))
    
