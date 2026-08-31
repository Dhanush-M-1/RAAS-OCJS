n,m = map(int, input().split())
a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()))

a_difs = [a[i+1]-a[i] for i in range(n-1)]
a_difs.append((a[0]-a[n-1])%m)

b_difs = [b[i+1]-b[i] for i in range(n-1)]
b_difs = b_difs + [(b[0]-b[n-1])%m] + b_difs

# print (a_difs, b_difs)
answer = m
for i in range(n):
    ok = True
    for j in range(n):
        if a_difs[j]!=b_difs[i+j]:
            ok = False
            break
    if ok:
        answer = min(answer, (b[i]-a[0])%m)

print (answer)