N = int(input())
for q in range(N):
    l, r, d = map(int, input().split())
    if d<l:
        answer = d
    else:
        answer = (r//d + 1)*d
    print(answer)
