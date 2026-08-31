a = [5,7,5,7,7]
 
while True:
    n = int(input())
    if n == 0: break
    w = list(map(lambda x: len(input()) , range(n)))
    ans = 0
    for i in range(n):
        aa, g = 0, 0
        for j in range(i, n):
            g += w[j]
            if g == a[aa]:
                g =  0
                aa += 1
                if aa == 5:
                    ans = i+1
                    break
            elif g > a[aa]:
                break
        if ans:
            break
    print(ans)
