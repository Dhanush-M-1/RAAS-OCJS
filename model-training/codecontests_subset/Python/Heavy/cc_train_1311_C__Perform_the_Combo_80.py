import sys

input = sys.stdin.readline
xd = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

for j in range(int(input())):
    
    n, m = map(int, input().split(" "))
    s = input().rstrip()
    p = list(map(int, input().split(" ")))
    p.append(len(s))
    tr = []
    grow = [0 for k in range(26)]
    ans = [0 for k in range(26)]
    for m in range(len(s)):
        grow[ord(s[m])-97] = grow[ord(s[m])-97]+1
        tr.append(grow)
        grow = grow.copy()
    for omg in p:
        for j in range(26):
            ans[j] = ans[j]+tr[omg-1][j]
    for fk in range(len(ans)):
        ans[fk] = str(ans[fk])
    print(" ".join(ans))
