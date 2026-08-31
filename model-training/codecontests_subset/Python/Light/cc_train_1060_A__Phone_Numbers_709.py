n = int(input())
a = input()
ar = list(a)
ei = '8'
cnt =0
for i in ar:
    if ei ==i:
        cnt += 1

rr = 0
if n>=11:
    if '8' in ar:
        ans = n//11
        rr = min(cnt,ans)


print(rr)

