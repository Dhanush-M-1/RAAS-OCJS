def patrion(arr,l,h):
    p=arr[h]
    i=l-1
    for j in range(l,h):
        if arr[j]<p:
            i+=1
            arr[i],arr[j]=arr[j],arr[i]
    arr[i+1],arr[h]=arr[h],arr[i+1]
    return i+1
def quicksort(arr,l,h):
    if l<h:
        res=patrion(arr,l,h)
        quicksort(arr,l,res-1)
        quicksort(arr,res+1,h)
        return arr
input=input().split("+")
if len(input)<=1:
    print("".join(input))
else:    
    length=len(input)-1
    result=quicksort(input,0,length)
    for i in range(1,(len(result)-1)*2,2):
        result.insert(i,"+")
    print("".join(result))
