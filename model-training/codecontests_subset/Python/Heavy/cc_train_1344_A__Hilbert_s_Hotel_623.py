def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    visit = {}
    visit2 = {}
    count = 0
    for i in range(n):
        curr = i + arr[count]
        if curr not in visit:
            visit[curr] = 0
        else:
            return "NO"
        count += 1
    for i in visit.keys():
        curr = int(i)%n
        if curr not in visit2:
            visit2[curr] = 0
        else:
            return "NO"
    return "YES"

numcases = int(input())
for i in range(numcases):
        print(solve())