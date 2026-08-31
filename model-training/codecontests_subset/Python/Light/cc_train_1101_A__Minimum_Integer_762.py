query = int(input())
for q in range(query):
    l, r, d = map(int, input().split())
    ans = 1
    if (d < l or d > r):
        print(d)
    else:
        print((r//d+1)*(d))
