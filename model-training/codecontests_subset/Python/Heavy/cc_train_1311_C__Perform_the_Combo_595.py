t = int(input())

for i in range(t):
    al = dict()
    for i in range(ord('a'), ord('z')+1): al.update({chr(i): 0})

    n, m = map(int, input().split())
    s = input()
    pts = list(map(int, input().split()))

    pts.sort()
    pts.append(n)

    pp = 0
    count = 0
    for p in pts:
        if p == pp:
            count += 1
            continue
        else:
            for q in s[pp:p]:
                al[q] += m-count+1
            pp = p
            count += 1
    print(*al.values())