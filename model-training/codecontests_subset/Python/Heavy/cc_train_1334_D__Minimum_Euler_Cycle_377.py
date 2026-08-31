import sys

#  2 -> 1 2 1
#  3 -> 1 2 1 3 2 3 1
#  4 -> 1 2 1 3 1 4 2 3 2 4 3 4 1
#  5 -> 1 2 1 3 1 4 1 5  2 3 2 4 2 5  3 4 3 5  4 5  1

# for X(k, 1): first 2(k-1) are  1, i; then (k-1)(k-2) are X(k-1, 2) ; then 1

# 2(k-1), 2(k-2), 2(k-3) ...


def binsearch(i, n):

    last = n*(n-1)
    ip = n*(n-1) - i
    
    #print(f"binsearch({i},{n}) last={last} ip={ip}")
    jprev = 0
    j = n-1

    while True:
        #print(f"j={j}, jprev={jprev}")
        #print(f"{j} {last-j*(j-1)} {last-(j-2)*(j-1)} ")
        step = max(1, abs(jprev-j)//2)
        jprev = j
        if j*(j-1) < ip:
            j += step
        elif j > 1 and (j-1)*(j-2) >= ip:
            j -= step
        else:
            break

    k = i - (last - j*(j-1))
    return j, k


def segment(n, l, r):

    res = []
    j1, k1 = binsearch(l-1, n)
    j2, k2 = binsearch(r-1, n)

    # print(f"from {j1, k1} to {j2, k2}")

    for j in range(j1, j2-1, -1):
        for k in range(2*(j-1)):
            if not (j==j1 and k<k1) and not (j==j2 and k>k2):
                if k % 2 == 0:
                    res.append(n-j+1)
                else:
                    res.append(k // 2 + n-j + 2)
    if j2 == 1 and k2 == 0:
        res.append(1)
    return res

t = int(input().strip())

for _ in range(t):
    n, l, r = list(map(int, input().strip().split()))

    print(' '.join(map(str, segment(n, l, r))))


