n , m = input().split()
l=[]
for i in range(int(n)):
    arr = list(map(int, input().split()))
    for i in arr[1:]:
        if i not in l:
            l.append(i)
if len(l) == int(m):
    print("YES")
else:
    print("NO")