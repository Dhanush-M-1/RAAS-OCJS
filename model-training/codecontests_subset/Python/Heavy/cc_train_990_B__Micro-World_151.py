s=input()
t=input()
arr1=list(map(int, s.split()))
arr2=list(map(int, t.split()))

arr2.sort()
#print(arr2)
arr = []
freq = []
freq.append(1)
arr.append(arr2[0])
for j in range (1,arr1[0]):
    if(arr2[j] != arr2[j-1]):
        arr.append(arr2[j])
        freq.append(1)
    else:
        freq[len(freq)-1] = freq[len(freq)-1] + 1    

    
#print(arr)
#print(freq)
count = arr1[0]

for i in range (0,len(arr)-1):
    if(arr[i+1]>arr[i] and arr[i+1]-arr[i] <= arr1[1]):
        count = count - freq[i]
print(count)

    
