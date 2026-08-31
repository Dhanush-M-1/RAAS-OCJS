n,m = list(map(int, input().split()))
temp = [i for i in range(1, m+1)]
lst = set()
for i in range(n):
    x =  list(map(int, input().split()))
    ans = x[1:]
    for i in ans:
        lst.add(i)
for i in temp:
    if i not in lst:
        print("NO")
        break
else:
    print("YES")