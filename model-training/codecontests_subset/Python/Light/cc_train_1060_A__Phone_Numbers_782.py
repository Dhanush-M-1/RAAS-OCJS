x = int(input())
y = input()
arr = [0]*10
for i in range (x) :
    arr[int(y[i])]+=1
z = sum(arr)//11
print(min(z,arr[8]))
