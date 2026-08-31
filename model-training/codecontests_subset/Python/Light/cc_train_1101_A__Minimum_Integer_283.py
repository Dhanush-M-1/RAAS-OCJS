tc = int(input())
for _ in range(tc):
    l, r, d = map(int, input().split(' '))
    
    ans = d
    if ans >= l:
        mod = r % d
        ans = r + (d - mod)
    
    print(ans)