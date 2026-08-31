t = int(input())

def add(a, b):
    ret = []
    for i in range(len(a)):
        ret.append(a[i] + b[i])
    return ret
def get_list(s):
    ret = [0 for i in range(26)]
    for i in s:
        ret[ord(i) - ord('a')] += 1
    return ret
for _ in range(t):
    n, m = [int(x) for x in input().split()]
    s = input()
    ret = [0 for i in range(26)]
    prefix = [0 for i in range(n)]
    for i in input().split():
        prefix[int(i)-1] += 1
    for i in range(n-1, 0, -1):
        prefix[i-1] += prefix[i]
    for i in range(n):
        ret[ord(s[i]) - ord('a')] += prefix[i]
        ret[ord(s[i]) - ord('a')] += 1
    for i in ret:
        print(i, end=" ")
    print()
