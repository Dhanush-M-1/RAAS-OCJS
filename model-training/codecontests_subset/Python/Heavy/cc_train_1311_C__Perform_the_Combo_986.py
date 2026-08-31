import copy

alphabet = ['a''b''c''d''e''f''g''h''i''j''k''l''m''n''o''p''q''r''s''t''u''v''w''x''y''z'][0]
def ai(ind):
    return alphabet.index(ind)


def solution(n, m, s, p):
    p = [pi - 1 for pi in p]
    p.append(n - 1)
    numbers = [[0] * 26]
    numbers[0][ai(s[0])] = 1
    for i in range(1, n):
        numbers.append(copy.copy(numbers[i - 1]))
        #print(s[i])
        numbers[i][ai(s[i])] += 1
    ans = [0] * 26
    for i in range(m + 1):
        for j in range(26):
            ans[j] += numbers[p[i]][j]
    print(' '.join(map(str, ans)))


t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    solution(n, m, s, p)
