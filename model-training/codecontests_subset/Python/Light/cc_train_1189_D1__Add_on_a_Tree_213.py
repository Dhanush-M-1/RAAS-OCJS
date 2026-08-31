n = int(input())
deg = [0]*n

for i in range(n-1):
    u, v = map(int, input().split())
    deg[u-1] += 1
    deg[v-1] += 1

if all(i != 2 for i in deg):
    print("YES")
else:
    print("NO")

# cnt = sum(1 for i in deg if i == 1)
# if cnt*(cnt-1)//2 >= n - 1:
    # print("YES")
# else:
    # print("NO")