arr=[]
for i in range(int(input())):
    arr.append([int(x) for x in input().split()])
p = arr[0][0]
count=i=1
while i<len(arr):
    if arr[i][0]-arr[i][1]>p:
        p = arr[i][0]
        count+=1
    elif i<len(arr)-1 and arr[i][0]+arr[i][1]<arr[i+1][0]:
        p = arr[i][0]+arr[i][1]
        count+=1
    elif i==len(arr)-1:
        count+=1
    else:
        p = arr[i][0]
    i+=1
print(count)