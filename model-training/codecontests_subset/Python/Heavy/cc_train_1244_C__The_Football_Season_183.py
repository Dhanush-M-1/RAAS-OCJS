#Problem 3 more elegant
n, p, w, d = map(int,input().split())
p_max = n*w
w_count = 0
d_count = 0
score = 0
if p_max < p:
    print("-1")
else:
    maxwins = int(p/w)
    if w*maxwins > p:
        maxwins = maxwins -1
    n -= maxwins
    score = maxwins * w
    w_count += maxwins
    if score == p:
        print(int(w_count), 0, int(n))
    elif w > p and d > p:
        print(-1)
    else:
        while score < p:
            scorediff = p - score
            if scorediff % d == 0:
                if n >=  scorediff/d:
                    d_count += scorediff/d
                    n -= d_count
                    print(int(w_count), int(d_count), int(n))
                    break
                else:
                    print(-1)
                    break
            else:
                score -= w
                w_count -= 1
                n +=  1
                if n * d < p - score:
                    print(-1)
                    break
                if w%d ==0:
                    print(-1)
                    break