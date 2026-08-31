n = int(input())
s = input()
ctx=s.count('8')
ans=0
if ctx>0:
    possi = n // 11
    ans = min (ctx,possi)
print(ans)
