n = int(input())
a = input().split()
a = [int(i) for i in a]
b = []
c = []
for i in a:
    b.append(i%2)
if b.count(1) == b.count(0) or abs(b.count(0)-b.count(1)) == 1:
    print(0)
else:
    sum = 0
    cnt1 = b.count(1)
    cnt0 = b.count(0)
    if cnt0 > cnt1:
        c = [i for i in a if i%2 == 0]
        for i in range(cnt0-cnt1-1):
            sum += min(c)
            c.remove(min(c))
    else:
        c = [i for i in a if i%2 == 1]
        for i in range(cnt1-cnt0-1):
            sum += min(c)
            c.remove(min(c))
    print(sum)
