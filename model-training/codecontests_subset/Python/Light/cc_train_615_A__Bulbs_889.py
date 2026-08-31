n, m = map(int, input().split())
connected = [False for _ in range(m)]
for i in range(n):
    a = list(map(int, input().split()))
    for j in range(1, len(a)):
        connected[a[j] - 1] = True
allconnected = True
for j in range(m):
    if connected[j] == False:
        allconnected = False

if allconnected == True:
    print("YES")
else:
    print("NO")