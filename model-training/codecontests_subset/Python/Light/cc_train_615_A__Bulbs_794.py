n,m = [int(x) for x in input().split()]
set1=set()
for i in range(n):
    lst1 = [int(x) for x in input().split()]
    lst1.pop(0)
    set2 = set(lst1)
    set1 =set2 | set1
if len(set1) == m:
    print("YES")
else:print("NO")
