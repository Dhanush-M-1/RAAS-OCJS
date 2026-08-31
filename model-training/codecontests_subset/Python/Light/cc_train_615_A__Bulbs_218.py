n, m = map(int, input().split())
fli = []
for _ in range(n):
    li = list(map(int, input().split()))
    li.remove(li[0])
    fli.extend(li)
    
if len(set(fli)) == m and max(set(fli)) == m:
    print("YES")
else:
    print("NO")