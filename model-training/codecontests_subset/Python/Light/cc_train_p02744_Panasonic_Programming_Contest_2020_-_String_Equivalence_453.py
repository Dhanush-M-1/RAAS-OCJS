def solve(s):
    if len(s)==n:
        a.append(''.join(chr(c+97)for c in s))
        return
    for i in range(max(s)+2):
        solve(s+[i])
n=int(input())
a=[]
solve([0])
print(*a)