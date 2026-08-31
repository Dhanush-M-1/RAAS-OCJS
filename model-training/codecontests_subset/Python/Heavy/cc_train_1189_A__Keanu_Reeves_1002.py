n = int(input())
d = [int(x) for x in list(input())]
if len(d) == 1:
    print(1)
    print(d[0])
    exit(0)
if d.count(0) != len(d)-d.count(0):
    print(1)
    for x in d: print(x,end='')
    exit(0)
result = []
count = 2
while True:
    for i in range(0,n-1):
        left = d[:i+1]
        right= d[i+1:]
        nleft = left.count(0)
        nright = right.count(0)
        if len(left)-nleft != nleft and len(right)-nright != nright:
            print(count)
            result.append(left)
            result.append(right)
            for x in result:
                for y in x:
                    print(y,end='')
                print(' ', end='')
            exit(0)
    result.append(d[0:1])
    d[0:1] = []
    count += 1