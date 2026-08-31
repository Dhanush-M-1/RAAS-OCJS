#選択ソート
number=eval(input())
swap=0
arr=list(map(int, input().split(' ')))
for i in range(number-1):
    minI=arr.index(min(arr[i:]),i)
    if i!=minI:
        arr[i],arr[minI]=arr[minI],arr[i]
        swap+=1
print(' '.join(map(str, arr)))
print(swap)
