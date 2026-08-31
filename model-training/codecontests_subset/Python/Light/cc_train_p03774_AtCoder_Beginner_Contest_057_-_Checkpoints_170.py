N, M = map(int, input().split())

students = [list(map(int, input().split())) for _ in range(N)]
checkpts = [list(map(int, input().split())) for _ in range(M)]

for a, b in students:
    tmp = [abs(a-x) + abs(b-y) for x, y in checkpts]
    print(tmp.index(min(tmp))+1)
