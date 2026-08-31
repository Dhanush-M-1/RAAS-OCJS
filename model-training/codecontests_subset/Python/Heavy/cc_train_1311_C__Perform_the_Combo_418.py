from sys import stdin
input = stdin.readline
for _ in range(int(input())):
    n,m = list(map(int, input().strip().split()))
    string = input().strip()
    array = list(map(int, input().strip().split()))
    counts = []
    dick = {}
    for i in string:
        dick[i] = dick.get(i, 0) + 1
        counts.append(dick.copy())
    ans = {}
    for i in array:
        for j in counts[i-1]:
            ans[j] = ans.get(j, 0) + counts[i-1][j]
    this = [0]*26
    for i in ans:
        this[ord(i)-ord('a')] = ans[i]
    for i in string:
        this[ord(i)-ord('a')] += 1
    print(*this)