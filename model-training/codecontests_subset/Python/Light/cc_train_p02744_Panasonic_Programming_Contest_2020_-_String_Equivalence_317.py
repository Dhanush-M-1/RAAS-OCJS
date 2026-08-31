n=int(input())
ans = ['a']
for i in range(1,n):
    ans_ = []
    for j in ans:
        for k in range(ord(max(j))-95):
            ans_.append(j+chr(97+k))
    ans = ans_.copy()
    
ans = sorted(ans)
for i in ans:
    print(i)