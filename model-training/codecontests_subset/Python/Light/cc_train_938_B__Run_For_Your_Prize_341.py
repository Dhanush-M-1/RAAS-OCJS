n = int (input())
a = list(input().strip().split(' '))
b = [int (x) for x in a]
a = [0]
a = a * (1000010)
l = len (b)
for i in range (l) :
    a[b[i]] = 1

l = 1
r = 1e6
ans = 1e7
# print (a)
if n == 0 :
    print (0)
else :
    while r >= l :
        # print (l,r)
        mid = int ((l + r) // 2)
        count = 0
        for i in range (mid) :
            if a[i + 2] :
                count += 1
            if a[1000000 - i - 1] :
                count += 1
        if (count >= n) :
            ans = min (ans, mid)
            r = mid - 1
        else :
            l = mid + 1
print (ans)

