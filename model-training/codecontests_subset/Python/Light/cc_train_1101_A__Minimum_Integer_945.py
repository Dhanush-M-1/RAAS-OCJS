q = int(input())
a = []
for i in range(0,q):
    l,r,m = map(int,input().split())
    if m < l:a.append(m)
    else:a.append((r // m + 1)  * m)
for i in range(0,len(a)):
    print(a[i])
