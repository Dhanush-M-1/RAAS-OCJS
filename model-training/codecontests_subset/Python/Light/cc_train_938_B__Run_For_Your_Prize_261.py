a = input()
arr =  list(map(int, input().split()))
arr.sort()
ans2 = 0;
ans1 = 0;
C = 10**6
for i in range(len(arr)):
    if (arr[i] <= C // 2):
        ans1 = arr[i] - 1;
    if (arr[i] > C // 2 and ans2 == 0):
        ans2 = C - arr[i];

print(max(ans1, ans2))
