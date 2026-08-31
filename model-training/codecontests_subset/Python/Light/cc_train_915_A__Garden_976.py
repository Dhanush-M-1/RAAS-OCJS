n, k = [int(i) for i in input().split()]

ans = -1
temp_max = 0

inp = [int(i) for i in input().split()]

for i in range(len(inp)):
    if (inp[i] > temp_max and k % inp[i] == 0):
        temp_max = inp[i]
        ans = k // inp[i]

print(ans)