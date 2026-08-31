n,k,p = map(int,input().split())

a = list(map(int,input().split()))
b = list(map(int,input().split()))

a.sort()
b.sort()

#print(a)
#print(b)

def cost(j):
    if j < 0 or j + n - 1 >= k:
        return 1000000000000
    maximum = 0
    for i in range(n):
        t = abs(a[i] - b[i+j]) + abs(b[i+j] - p)
        maximum = max(maximum,t)
    return maximum

l = 0
r = k - n
#Binary Search on l,r
while l < r:
    mid = (l+r)//2
    cost1 = cost(mid)
    cost1r = cost(mid+1)
    #print("r = {}, l = {}, cost1 = {}, cost1r = {}".format(l,r,cost1,cost1r))
    if cost1 < cost1r:
        r = mid
    else:
        l = mid+1
print(cost(l))
