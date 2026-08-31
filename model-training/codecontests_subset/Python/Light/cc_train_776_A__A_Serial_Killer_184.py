arr = input().split()
n = int(input())
ans1= arr[0]
ans2= arr[1]
print(ans1,ans2)
for i in range(0, n):
    name = input().split()
    if arr[0] == name[0]:
        arr[0] = name[1]
    else:
        arr[1] = name[1]
    ans1 = arr[0]
    ans2 = arr[1]
    print(ans1, ans2)
