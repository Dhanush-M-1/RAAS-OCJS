n = int(input())
arr = list(map(int, input().split()))
m = int(input())

q = []

for i in range(m):
    a, b = map(int, input().split())
    q.append((a, b))

def f(arr, m):
    vis = [False] * len(arr)
    
    arr2 = []
    for i in range(len(arr)):
        arr2.append([arr[i], n - i])
    
    arr2.sort(reverse=True)
    
    arr2 = arr2[:m]
    for i in range(len(arr2)):
        arr2[i][1] = n - arr2[i][1]
    
    arr2.sort(key=lambda x: x[1])

    res = []
    for i in range(len(arr2)):
        res.append(arr2[i][0])
    return res

for i in q:
    x = f(arr, i[0])
    print(x[i[1] - 1])