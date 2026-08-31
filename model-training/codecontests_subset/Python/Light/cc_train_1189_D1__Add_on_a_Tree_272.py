#572_D1

n = int(input())

arr = [0] * n

for i in range(0, n - 1):
    l = [int(j) for j in input().split(" ")]
    arr[l[0] - 1] += 1
    arr[l[1] - 1] += 1

print(["YES", "NO"][2 in arr])
