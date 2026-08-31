from collections import OrderedDict
n,m = list(map(int,input().split(' ')))
a = list(map(int,input().split(' ')))
b = list(map(int,input().split(' ')))

a.sort()
b.sort()

# print(a)
# print(b)

def diff(a,b,off):
    ans = - 1
    # print('#',off);
    for i in range(n):
        v = b[(i + off)%n] - a[i]
        if v < 0:
            v = m + v
        # print(v)
        if ans != -1 and ans != v:
            return 1e9
        ans = v
    return ans

mn = int(1e9)
for i in range(n):
    mn = min(diff(a,b,i),mn)
print(mn)