n = int(input())
for _ in range(n):
    l,r,d  = map(int, input().split())
    print(d if d < l else r+(d-r%d))
