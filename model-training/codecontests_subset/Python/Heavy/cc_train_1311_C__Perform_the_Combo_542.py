# maa chudaaye duniya
from string import ascii_lowercase

for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    ans = [0 for i in range(26)]
    p = list(map(int, input().split()))
    dicts = {}
    for i in ascii_lowercase:
        dicts[i] = [0 for j in range(n+1)]
    for i in range(n):
        curr = s[i]
        for character in ascii_lowercase:
            if curr == character:
                dicts[curr][i+1] = dicts[curr][i] + 1
            else:
                dicts[character][i+1] = dicts[character][i]
    # for i in set(s):
    #     print(i, dicts[i])
    for element in p:
        for character in ascii_lowercase:
            ans[ord(character) - ord('a')] += dicts[character][element]
    for e in s:
        ans[ord(e) - ord('a')] += 1
    print(*ans)