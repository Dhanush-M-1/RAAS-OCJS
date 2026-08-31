n = int(input().strip())
ll = []
ii = []
for i in range(n):
    k = list(map(int,input().split()))
    ll.append(k[0])
    ii.append(k[1])
j = 1
l = ll[0]
for i in range(1,n-1):
    if ll[i] - ii[i] > l:
        j += 1
        l = ll[i]
    elif ll[i] + ii[i] < ll[i+1]:
        j += 1
        l = ll[i] + ii[i]
    else:
        l = ll[i]
if n > 1:
    j += 1
print(j)


