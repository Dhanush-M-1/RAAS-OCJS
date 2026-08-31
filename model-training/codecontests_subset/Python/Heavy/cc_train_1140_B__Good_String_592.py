# for t in range(int(input())):
#     s = input()
#     i, j = 0, 0
#     cnt = 0
#     ans = float('inf')
#     dic = {}
#     while j < len(s):
#         if len(dic) < 3:
#             dic[s[j]] = dic.get(s[j], 0) + 1
#         # print(j)
#         # print(dic)
#         while len(dic) == 3:
#             ans = min(ans, j - i + 1)
#             dic[s[i]] -= 1
#             if dic[s[i]] == 0:
#                 del dic[s[i]]
#             i += 1
#
#         j += 1
#     print((0, ans)[ans < float('inf')])


# for t in range(int(input())):
#     n = int(input())
#     s = list(map(int, input().split()))
#     dp = [1] * n
#     for i in range(n):
#         k = 2
#         while (i + 1) * k <= n:
#             j = (i + 1) * k
#             if s[i] < s[j - 1]:
#                 dp[j - 1] = max(dp[j - 1], dp[i] + 1)
#             k += 1
#     print(max(dp))


# for T in range(int(input())):
#     t = input()
#     z, o = 0, 0
#     for ch in t:
#         z = z + 1 if ch == '0' else z
#         o = o + 1 if ch == '1' else o
#     if z > 0 and o > 0:
#         print('01' * len(t))
#     elif o > 0 and not z:
#         print('1' * len(t))
#     else:
#         print('0' * len(t))


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     a.sort()
#     ans = []
#     while a:
#         ans.append(str(a.pop(len(a) // 2)))
#     print(' '.join(ans))


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     cnt = 0
#     p = set()
#     l, r = 0, sum(a)
#     left, right = {}, {}
#     for i in a:
#         right[i] = right.get(i, 0) + 1
#     for i in range(n - 1):
#         l += a[i]
#         left[a[i]] = left.get(a[i], 0) + 1
#         r -= a[i]
#         right[a[i]] = right.get(a[i], 0) - 1
#         if not right[a[i]]:
#             del right[a[i]]
#         j = n - i - 1
#         if (2 + i) * (i + 1) // 2 == l and (j + 1) * j // 2 == r:
#             if len(left) == i + 1 and len(right) == j:
#                 cnt += 1
#                 p.add((i + 1, n - i - 1))
#     print(cnt)
#     if cnt:
#         for el in p:
#             print(*el)


# for t in range(int(input())):
#     n = int(input())
#     G = []
#     taken = [False] * n
#     girl = -1
#     for i in range(n):
#         g = list(map(int, input().split()))
#         k = g[0]
#         single = True
#         for j in range(1, k + 1):
#             if not taken[g[j] - 1]:
#                 taken[g[j] - 1] = True
#                 single = False
#                 break
#         if single:
#             girl = i
#     if girl == -1:
#         print('OPTIMAL')
#     else:
#         print('IMPROVE')
#         print(girl + 1, taken.index(False) + 1)


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     odd, even = [], []
#     for i in range(2 * n):
#         if a[i] % 2:
#             odd.append(i + 1)
#         else:
#             even.append(i + 1)
#     for i in range(n - 1):
#         if len(odd) >= len(even):
#             print(odd.pop(), odd.pop())
#         else:
#             print(even.pop(), even.pop())


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     a.sort()
#     ans, i, j = 0, 0, 1
#     while j < n:
#         if a[i] < a[j]:
#             ans += 1
#             i += 1
#             j += 1
#         else:
#             while j < n and a[i] == a[j]:
#                 i += 1
#                 j += 1
#     print(ans + 1)


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     got = False
#
#     b = 1
#     while not got and b < 2 * n - 1:
#         if b % 2:
#             i, j = (b - 1) // 2, (b + 1) // 2
#         else:
#             i, j = b // 2 - 1, b // 2 + 1
#         left, right = set(a[:i]), set(a[j:])
#         if left & right:
#             got = True
#         b += 1
#     print('YES' if got else 'NO')


# n, m, k = list(map(int, input().split()))
# A = list(map(int, input().split()))
# B = list(map(int, input().split()))
# ans = 0
# a, b = [0], [0]
# for el in A:
#     a.append(a[-1] + el)
# for el in B:
#     b.append(b[-1] + el)
# d = [(i, k//i) for i in range(1, int(k**0.5)+1) if k % i == 0]
# d += [(j, i) for i, j in d if i != j]
# for i in range(n):
#     for j in range(m):
#         for q, p in d:
#             if i + q <= n and j + p <= m:
#                 if a[i + q] - a[i] == q and b[j + p] - b[j] == p:
#                     ans += 1
# print(ans)


# for t in range(int(input())):
#     n = int(input())
#     s = input()
#     dic, se = {s: 1}, {s}
#     for k in range(2, n):
#         p = s[k - 1:] + (s[:k - 1], s[:k - 1][::-1])[(n % 2) == (k % 2)]
#         # print(k, p)
#         if p not in dic:
#             # print(dic, p)
#             dic[p] = k
#             se.add(p)
#     if s[::-1] not in dic:
#         dic[s[::-1]] = n
#         se.add(s[::-1])
#     # print(dic)
#     ans = min(se)
#     print(ans)
#     print(dic[ans])


# for t in range(int(input())):
#     a, b, p = list(map(int, input().split()))
#     s = input()
#     road = [a if s[0] == 'A' else b]
#     st = [0]
#     for i in range(1, len(s) - 1):
#         if s[i] != s[i - 1]:
#             road.append(road[-1] + (a, b)[s[i] == 'B'])
#             st.append(i)
#     # print(road)
#     pay = road[-1]
#     j = 0
#     while pay > p and j < len(st):
#         pay = road[-1] - road[j]
#         j += 1
#     # print(j)
#     print(st[j] + 1 if j < len(st) else len(s))


# for t in range(int(input())):
#     n, x, y = list(map(int, input().split()))
#     print(max(1, min(x + y - n + 1, n)), min(n, x + y - 1))


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     print(' '.join(map(str, sorted(a, reverse=True))))


# s = input()
# open, close = [], []
# i = 0
# for i in range(len(s)):
#     if s[i] == '(':
#         open.append(i)
#     else:
#         close.append(i)
# i, j = 0, len(close) - 1
# ans = []
# while i < len(open) and j >= 0 and open[i] < close[j]:
#     ans += [open[i] + 1, close[j] + 1]
#     i += 1
#     j -= 1
# ans.sort()
# print('0' if not ans else '1\n{}\n{}'.format(len(ans), ' '.join([str(idx) for idx in ans])))


import collections
# n, m = list(map(int, input().split()))
# a = list(input() for i in range(n))
# dic = {}
# for w in a:
#     dic[w] = dic.get(w, 0) + 1
# l, r = '', ''
# for i in range(n):
#     for j in range(i + 1, n):
#         # print(i, j, a)
#         if a[i] == a[j][::-1] and dic[a[i]] and dic[a[j]]:
#             l += a[i]
#             r = a[j] + r
#             dic[a[i]] -= 1
#             dic[a[j]] -= 1
# c = ''
# for k, v in dic.items():
#     if v and k == k[::-1]:
#         if c and c[-m] == k or not c:
#             c += k
# print(f'{len(l) + len(c) + len(r)}\n{l + c + r}')


# for t in range(int(input())):
#     n, g, b = list(map(int, input().split()))
#     d = n // 2 + n % 2
#     full, inc = divmod(d, g)
#     ans = (g + b) * (full - 1, full)[inc > 0] + (g, inc)[inc > 0]
#     print(ans if ans >= n else n)


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     a.sort()
#     print(a[n] - a[n - 1])


# for t in range(int(input())):
#     n, x = list(map(int, input().split()))
#     s = input()
#     cntz = s.count('0')
#     total = 2 * cntz - n
#     bal = 0
#     ans = 0
#     for i in range(n):
#         if not total:
#             if bal == x:
#                 ans = -1
#         elif not abs(x - bal) % abs(total):
#             if (x - bal) // total >= 0:
#                 ans += 1
#         bal += 1 if s[i] == '0' else -1
#     print(ans)


# n = int(input())
# ans = 0
# for i in range(1, n + 1):
#     ans += 1 / i
# print(ans)


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     p, s = 0, n - 1
#     for i in range(n):
#         if a[i] < i:
#             break
#         p = i
#     for i in range(n - 1, -1, -1):
#         if a[i] < n - i - 1:
#             break
#         s = i
#     print('Yes' if s <= p else 'No')


# n, k = list(map(int, input().split()))
# a = [input() for i in range(n)]
# c = set(a)
# b = set()
# for i in range(n):
#     for j in range(i + 1, n):
#         third = ''
#         for c1, c2 in zip(a[i], a[j]):
#             if c1 == c2:
#                 third += c1
#             else:
#                 if c1 != 'S' and c2 != 'S':
#                     third += 'S'
#                 elif c1 != 'E' and c2 != 'E':
#                     third += 'E'
#                 else:
#                     third += 'T'
#         if third in c:
#             b.add(frozenset([a[i], a[j], third]))
# print(len(b))


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     total, curr = sum(a), 0
#     ans, i, start = 'YES', 0, 0
#     while ans == 'YES' and i < n:
#         if curr > 0:
#             curr += a[i]
#         else:
#             curr = a[i]
#             start = i
#         # print(curr, i, start, total)
#         if i - start + 1 < n and curr >= total:
#             ans = 'NO'
#         i += 1
#     print(ans)


# for t in range(int(input())):
#     n, p, k = list(map(int, input().split()))
#     a = list(map(int, input().split()))
#     a.sort(reverse=True)
#     odd, even = 0, 0
#     i, j = len(a) - 1, len(a) - 2
#     curr = 0
#     while curr < p and i >= 0:
#         curr += a[i]
#         if curr <= p:
#             odd += 1
#         i -= 2
#     curr = 0
#     while curr < p and j >= 0:
#         curr += a[j]
#         if curr <= p:
#             even += 1
#         j -= 2
#     print(max(odd * 2 - 1, even * 2))


# for t in range(int(input())):
#     s, c = input().split()
#     s = list(ch for ch in s)
#     sor = sorted(s)
#     for i in range(len(s)):
#         if s[i] != sor[i]:
#             j = max(j for j, v in enumerate(s[i:], i) if v == sor[i])
#             s = s[:i] + [s[j]] + s[i + 1:j] + [s[i]] + s[j + 1:]
#             break
#     s = ''.join(s)
#     print(s if s < c else '---')


# for t in range(int(input())):
#     n, s = list(map(int, input().split()))
#     a = list(map(int, input().split()))
#     if sum(a) <= s:
#         print(0)
#     else:
#         curr, i, j = 0, 0, 0
#         for i in range(n):
#             if a[i] > a[j]:
#                 j = i
#             s -= a[i]
#             if s < 0:
#                 break
#         print(j + 1)


# for t in range(int(input())):
#     a, b = list(map(int, input().split()))
#     a, b = (b, a) if b > a else (a, b)
#     if not ((1 + 8 * (a - b))**0.5 - 1) % 2 and ((1 + 8 * (a - b))**0.5 - 1) // 2 >= 0:
#         ans = ((1 + 8 * (a - b))**0.5 - 1) // 2
#         print(int(ans))
#     else:
#         n1 = int(((1 + 8 * (a - b))**0.5 - 1) // 2) + 1
#         while (n1 * (n1 + 1) // 2) % 2 != (a - b) % 2:
#             n1 += 1
#         print(n1)


# for t in range(int(input())):
#     n = int(input())
#     a = list(map(int, input().split()))
#     a.sort()
#     ans = 0
#     l = 0
#     dic = {}
#     for i in range(n - 1, -1, -1):
#         if not a[i] % 2:
#             l, r = 0, 30
#             while l < r:
#                 m = (l + r) // 2
#                 # print(l, r, m, a[i] % 2**m)
#                 if a[i] % 2**m:
#                     r = m
#                 else:
#                     l = m + 1
#             dic[a[i] // 2**(l - 1)] = max(dic.get(a[i] // 2**(l - 1), 0), l - 1)
#     print(sum(list(dic.values())))


# n = int(input())
# s = input()
# b = s.count('B')
# w = n - b
# if b % 2 and w % 2:
#     print(-1)
# elif not b or not w:
#     print(0)
# else:
#     ans = []
#     if not b % 2:
#         for i in range(n - 1):
#             if s[i] != 'W':
#                 ans += [str(i + 1)]
#                 s = s[:i] + 'W' + 'BW'[s[i + 1] == 'B'] + s[i + 2:]
#     elif not w % 2:
#         for i in range(n - 1):
#             if s[i] != 'B':
#                 ans += [str(i + 1)]
#                 s = s[:i] + 'B' + 'WB'[s[i + 1] == 'W'] + s[i + 2:]
#     print(len(ans))
#     print(' '.join(ans))


# n, m = list(map(int, input().split()))
# a = list(map(int, input().split()))
# b = list(map(int, input().split()))
# b.sort()
# ans = float('inf')
# for i in range(n):
#     x = (b[0] - a[i]) % m
#     ax = []
#     for j in range(n):
#         ax.append((a[j] + x) % m)
#     if b == sorted(ax):
#         ans = min(ans, x)
# print(ans)


# for t in range(int(input())):
#     n = int(input())
#     ans = [1] + [0] * (n - 1)
#     p = list(map(int, input().split()))
#     i, j, curr, m = p.index(1), 1, 1, 1
#     l, r = i, i
#     while l >= 0 and r < n:
#         if l and curr + p[l - 1] == (m + 2) * (m + 1) // 2:
#             ans[m] = 1
#             curr += p[l - 1]
#             l -= 1
#
#         elif r + 1 < n and curr + p[r + 1] == (m + 2) * (m + 1) // 2:
#             ans[m] = 1
#             curr += p[r + 1]
#             r += 1
#         else:
#             if l and r + 1 < n:
#                 curr, l, r = ((curr + p[l - 1], l - 1, r),
#                               (curr + p[r + 1], l, r + 1))[p[r + 1] < p[l - 1]]
#             elif not l and r + 1 < n:
#                 curr, l, r = curr + p[r + 1], l, r + 1
#             elif r + 1 == n and l:
#                 curr, l, r = curr + p[l - 1], l - 1, r
#             else:
#                 break
#         m += 1
#     print(''.join([str(i) for i in ans]))


# for t in range(int(input())):
#     n = int(input())
#     p = [input() for i in range(n)]
#     ans = 0
#     for i in range(n):
#         if p[i] in p[i + 1:]:
#             for j in range(10):
#                 code = p[i][:3] + str(j)
#                 if code not in p:
#                     p[i] = code
#                     ans += 1
#                     break
#     print(ans)
#     for code in p:
#         print(code)


# for t in range(int(input())):
#     a, b = list(map(int, input().split()))
#     if (a + b) % 3 == 0 and 2 * min(a, b) >= max(a, b):
#         print('YES')
#     else:
#         print('NO')


# for t in range(int(input())):
#     x, y = list(map(int, input().split()))
#     if (x == 1 and y > 1) or (x == 2 and y > 3) or (x == 3 and y > 3):
#         print('NO')
#     else:
#         print('YES')


# for t in range(int(input())):
#     n, m = list(map(int, input().split()))
#     a = list(map(int, input().split()))
#     if m < n or n == 2:
#         print(-1)
#     elif m == n:
#         print(2 * sum(a))
#         for i in range(n - 1):
#             print(i + 1, i + 2)
#         print(n, 1)
#     else:
#         b = [(a[i], i + 1) for i in range(n)]
#         b.sort()
#         d = m - n
#         ans = sum(a) + d * (b[0][0] + b[1][0])
#         for i in range(d):
#             print(b[0][1], b[1][1])
#         for i in range(n - 1):
#             print(i + 1, i + 2)
#         print(n, 1)


# n = int(input())
# a = list(map(int, input().split()))
# if n % 2:
#     print(-1)
# else:
#     d = 0
#     c = []
#     curr = 0
#     came = set()
#     day = set()
#     inc = False
#     for i in range(n):
#         if a[i] > 0:
#             if a[i] in day:
#                 inc = True
#                 break
#             else:
#                 day.add(a[i])
#                 came.add(a[i])
#         else:
#             if abs(a[i]) not in came:
#                 inc = True
#                 break
#             else:
#                 came.remove(abs(a[i]))
#         if len(came) == 0:
#             d += 1
#             c.append(i + 1)
#             day = set()
#     if len(came) > 0:
#         inc = True
#     if inc:
#         print(-1)
#     else:
#         print(d)
#         print(c[0])
#         for i in range(1, len(c)):
#             print(c[i] - c[i - 1])


# n = int(input())
# a = list(map(int, input().split()))
# a.sort()
# x, y = sum(a[:n // 2])**2, sum(a[n // 2:])**2
# print(x + y)


# for t in range(int(input())):
#     n = int(input())
#     r, p, s = list(map(int, input().split()))
#     b = input()
#     S, P, R = b.count('S'), b.count('P'), b.count('R')
#     cnt = 0
#     ans = ''
#     # print(r, 'rock', p, 'paper', s, 'sc')
#     for i in range(n):
#         if b[i] == 'S':
#             if r > 0:
#                 ans, r, cnt = ans + 'R', r - 1, cnt + 1
#             else:
#                 if p > R:
#                     ans, p = ans + 'P', p - 1
#                 if len(ans) < i + 1 and s > P:
#                     ans, s = ans + 'S', s - 1
#             S -= 1
#         elif b[i] == 'P':
#             if s > 0:
#                 ans, s, cnt = ans + 'S', s - 1, cnt + 1
#             else:
#                 if p > R:
#                     ans, p = ans + 'P', p - 1
#                 if len(ans) < i + 1 and r > S:
#                     ans, r = ans + 'R', r - 1
#             P -= 1
#         else:
#             if p > 0:
#                 ans, p, cnt = ans + 'P', p - 1, cnt + 1
#             else:
#                 if s > P:
#                     ans, s = ans + 'S', s - 1
#                 if len(ans) < i + 1 and r > S:
#                     ans, r = ans + 'R', r - 1
#             R -= 1
#     if cnt < (n // 2 + n % 2):
#         print('NO')
#     else:
#         print('YES')
#         # print(r, p, s)
#         print(ans)


# for t in range(int(input())):
#     n = int(input())
#     s = input()
#     f, l = s.find('1'), s.rfind('1')
#     f, l = max(f + 1, n - f) if f != -1 else 0, max(l + 1, n - l) if l != -1 else 0
#     if not f and not l:
#         print(n)
#     else:
#         print(f * 2) if f > l else print(l * 2)


# t = int(input())
# ans = list()
# for _ in [0] * t:
#     n, r = map(int, input().split())
#     x = sorted(set(map(int, input().split())))[::-1]
#     ans.append(sum([x - i * r > 0 for i, x in enumerate(x)]))
# print(' '.join(map(str, ans)))


# n = int(input())
# dots = []
# for i in range(n):
#     dots.append(sum(list(map(int, input().split()))))
# print(max(dots))


# n, m = map(int, input().split())
# print(pow(2**m - 1, n, 10**9 + 7))


# n, k = map(int, input().split())
# s = input()
# if not k:
#     print(s)
# elif n == 1:
#     print('0')
# else:
#     s = [int(i) for i in s]
#     if s[0] > 1:
#         s[0], k = 1, k - 1
#     for i in range(1, n):
#         if not k:
#             break
#         if s[i] > 0:
#             s[i], k = 0, k - 1
#     print(''.join(map(str, s))) if len(s) > 1 else print('0')


# m, n = map(int, input().split())
# r = list(map(int, input().split()))
# c = list(map(int, input().split()))
# grid = [['ok'] * (n + 1) for i in range(m + 1)]
#
# for i in range(m):
#     row = r[i]
#     if row:
#         for j in range(row):
#             grid[i][j] = 1
#         grid[i][row] = 0
#     else:
#         grid[i][row] = 0
#
#
# inv = False
# for j in range(n):
#     col = c[j]
#     if col:
#         for i in range(col):
#             if grid[i][j] == 0:
#                 inv = True
#                 break
#             else:
#                 grid[i][j] = 1
#         if grid[col][j] == 1:
#             inv = True
#             break
#         else:
#             grid[col][j] = 0
#     else:
#         if grid[col][j] == 1:
#             inv = True
#             break
#         else:
#             grid[col][j] = 0
#
# if inv:
#     print(0)
# else:
#     cnt = 0
#     for row in grid[:m]:
#         cnt += row[:n].count('ok')
#     print(pow(2, cnt, 10**9 + 7))


# n = int(input())
# for i in range(n):
#     print('BW' * (n // 2) + 'B' * (n % 2) if i % 2 else 'WB' * (n // 2) + 'W' * (n % 2))


# n = int(input())
# a = list(map(int, input().split()))
# curr, odd, even = 0, 0, 0
# p = 0
# for d in a:
#     odd, even = ((odd, even + 1), (odd + 1, even))[curr % 2]
#     curr += 1 if d < 0 else 0
#     p += odd if curr % 2 else even
# print(n * (n + 1) // 2 - p, p)


# n = int(input())
# a = list(map(int, input().split()))
# p, m, z = 0, [], 0
# for d in a:
#     if d > 0:
#         p += d
#     elif d < 0:
#         m.append(d)
#     else:
#         z += 1
# ans = p - (n - z - len(m))
#
# if len(m) % 2:
#     if z:
#         m.append(-1)
#         ans += 1
#         z -= 1
#     else:
#         m.sort(reverse=True)
#         x = m.pop()
#         ans += 1 - x
#
# mm = len(m)
# ans += abs(sum(m)) - mm
# ans += z
# print(ans)


# n, l, r = map(int, input().split())
# a = [2**i for i in range(r)]
# print(sum(a[:l]) + n - l, sum(a) + (n - r) * a[-1])


# n = int(input())
# a = list(map(int, input().split()))
# a.sort()
# print('YES' if not sum(a) % 2 and a[-1] <= sum(a) - a[-1] else 'NO')


# for t in range(int(input())):
#     n, m, k = map(int, input().split())
#     h = list(map(int, input().split()))
#     ans = 'YES'
#     for i in range(n - 1):
#         if abs(h[i] - h[i + 1]) > k:
#             d = h[i] - h[i + 1]
#             if d < 0 and m >= abs(d) - k:
#                 m -= -k - d
#             elif d > 0:
#                 m += min(d + k, h[i])
#             else:
#                 ans = 'NO'
#                 break
#         else:
#             d = h[i] - h[i + 1]
#             if d >= 0:
#                 m += min(d + k, h[i])
#             else:
#                 m += min(k + d, h[i])
#     print(ans)


# h, l = map(int, input().split())
# print((h**2 + l**2) / (2 * h) - h)


# n = int(input())
# a = list(map(int, input().split()))
# a = {i: j for i, j in enumerate(a)}
# m, idx = 0, 0
# ans = 'YES'
# for i in range(n):
#     if a[i] > m:
#         m = a[i]
#         idx = i
# for i in range(1, idx):
#     if a[i] < a[i - 1]:
#         ans = 'NO'
#         break
# for i in range(idx + 1, n):
#     if a[i] > a[i - 1]:
#         ans = 'NO'
#         break
# print(ans)


# n, k = map(int, input().split())
# l, r = 0, n
# while l <= r:
#     m = (l + r) // 2
#     t = n - m
#     if m * (m + 1) // 2 - t == k:
#         ans = t
#         break
#     elif m * (m + 1) // 2 - t < k:
#         l = m + 1
#     else:
#         r = m - 1
# print(ans)


# for t in range(int(input())):
#     n, m = map(int, input().split())
#     grid = [input() for i in range(n)]
#     rows = []
#     cols = [0] * m
#     for row in grid:
#         rows.append(0)
#         for i in range(m):
#             if row[i] == '.':
#                 rows[-1] += 1
#                 cols[i] += 1
#     ans = m + n - 1
#     for i in range(n):
#         for j in range(m):
#             ans = min(ans, rows[i] + cols[j] - (grid[i][j] == '.'))
#     print(ans)


# tiles = input().split()
# unique = {}
# m, p, s = set(), set(), set()
# m_unique = 0
# for t in tiles:
#     unique[t] = unique.get(t, 0) + 1
#     m_unique = max(m_unique, unique[t])
#     if t[1] == 'm':
#         m.add(int(t[0]))
#     elif t[1] == 'p':
#         p.add(int(t[0]))
#     else:
#         s.add(int(t[0]))
# ans = 3 - m_unique
# for t in (m, p, s):
#     if not t:
#         continue
#     else:
#         m_sub = 0
#         l = list(sorted(t))
#         dif = []
#         for i in range(1, len(t)):
#             dif.append(l[i] - l[i - 1])
#             if dif[-1] == 1 or dif[-1] == 2:
#                 m_sub = max(m_sub, 2)
#             if i > 1 and dif[-1] == dif[-2] == 1:
#                 m_sub = 3
#             # print(l, dif, m_sub)
#     ans = min(ans, 3 - m_sub)
# print(ans)


# n = int(input())
# a = list(map(int, input().split()))
# a.sort()
# print('NO' if a[-3] + a[-2] <= a[-1] else 'YES')
# if a[-3] + a[-2] > a[-1]:
#     print(' '.join(str(i) for i in a[:-3] + [a[-3]] + [a[-1]] + [a[-2]]))


# n = int(input())
# s = input()
# m = int(input())
# dic = {}
# for i in range(n):
#     dic.setdefault(s[i], []).append(i)
# for t in range(m):
#     name = [ch for ch in input()]
#     c = {}
#     ans = 0
#     # print(t)
#     for i in range(len(name)):
#         idx = c.get(name[i], -1)
#         # print(name[i], dic[name[i]], c)
#         c[name[i]] = idx + 1
#         ans = max(ans, dic[name[i]][idx + 1])
#     print(ans + 1)


# for t in range(int(input())):
#     a = input()
#     b = input()
#     if len(b) < len(a):
#         print('NO')
#     else:
#         ans = 'YES'
#         i, j = 0, 0
#         while i < len(a):
#             cnt1 = 1
#             while i + 1 < len(a) and a[i] == a[i + 1]:
#                 cnt1 += 1
#                 i += 1
#             cnt2 = 0
#             while j < len(b) and b[j] == a[i]:
#                 cnt2 += 1
#                 j += 1
#             if cnt1 > cnt2:
#                 ans = 'NO'
#                 break
#             i += 1
#         print(ans if i == len(a) and j == len(b) else 'NO')


# m, n = map(int, input().split())
# g = [input() for i in range(m)]
# ans = 'YES'
# if m < 3 and n < 3:
#     ans = 'NO'
# if ans == 'YES':
#     c = (-1, -1)
#     for i in range(1, m - 1):
#         for j in range(1, n - 1):
#             if g[i][j] == '*':
#                 if all(g[I][J] == '*' for I, J in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))):
#                     c = (i, j)
#                     break
#     if c == (-1, -1):
#         ans = 'NO'
#
# if ans == 'YES':
#     plus = {c}
#     I, J = c
#     i, j = I - 1, I + 1
#     while i >= 0 and g[i][J] == '*':
#         plus.add((i, J))
#         i -= 1
#     while j < m and g[j][J] == '*':
#         plus.add((j, J))
#         j += 1
#     i, j = J - 1, J + 1
#     while i >= 0 and g[I][i] == '*':
#         plus.add((I, i))
#         i -= 1
#     while j < n and g[I][j] == '*':
#         plus.add((I, j))
#         j += 1
#
#     for i in range(m):
#         for j in range(n):
#             if g[i][j] == '*' and (i, j) not in plus:
#                 ans = 'NO'
#                 break
#
# print(ans)


# for t in range(int(input())):
#     n = int(input())
#     if not n % 2:
#         print(f'{n // 2} {n // 2}')
#     else:
#         idx = 1
#         for i in range(3, int(n**0.5) + 1):
#             if not n % i:
#                 idx = i
#                 break
#         print(f'{n // idx} {n - n // idx}' if idx > 1 else f'{1} {n - 1}')


# l = int(input())
# n = input()
# i = l // 2
# if not l % 2 and n[i] != '0':
#     print(int(n[:i]) + int(n[i:]))
# else:
#     j = i + 1
#     while n[i] == '0':
#         i -= 1
#     while j < l and n[j] == '0':
#         j += 1
#     if i > 0 and j < l - 1:
#         print(min(int(n[:i]) + int(n[i:]), int(n[:j]) + int(n[j:])))
#     else:
#         if not i:
#             print(int(n[:j]) + int(n[j:]))
#         else:
#             print(int(n[:i]) + int(n[i:]))


# n = int(input())
# a = list(map(int, input().split()))
# b = a.copy()
# for i in range(n):
#     if a[i] >= 0:
#         a[i] = (a[i] + 1) * -1
# if not n % 2:
#     print(' '.join((str(i) for i in a)))
# else:
#     m = (float('inf'), -1)
#     for i in range(n):
#         m = (m, (a[i], i))[m[0] > a[i] and a[i] < -1]
#     if m[1] == -1:
#         b[0] = 0
#         print(' '.join((str(i) for i in b)))
#     else:
#         a[m[1]] = (a[m[1]] + 1) * -1
#         print(' '.join((str(i) for i in a)))


# l = int(input())
# ans = 0
# c = [input() for i in range(l)]
# stack = [1]
# for i in range(l):
#     if c[i] == 'add':
#         ans += stack[-1]
#     elif c[i] == 'end':
#         stack.pop()
#     else:
#         stack.append(min(stack[-1] * int(c[i].split()[1]), 2**32))
#     if ans >= 2**32:
#         ans = 'OVERFLOW!!!'
#         break
# print(ans)


# n = int(input())
# a = list(map(int, input().split()))
# odd = 0
# for d in a:
#     if d % 2:
#         odd += 1
# if 0 < odd < n:
#     print(' '.join((str(i) for i in sorted(a))))
# else:
#     print(' '.join((str(i) for i in a)))


# n = int(input())
# print(n // 2 + 1)
# i, j = 1, 1
# for k in range(n):
#     print(i, j)
#     if i == j:
#         j += 1
#     else:
#         i += 1


# n, m = map(int, input().split())
# a = [list(map(int, input().split())) for i in range(m)]
# x, y = a.pop()
# ans = 'NO'
# for v in (x, y):
#     val = [0] * (n + 1)
#     cnt = 0
#     for v1, v2 in a:
#         if v1 != v and v2 != v:
#             val[v1], val[v2], cnt = val[v1] + 1, val[v2] + 1, cnt + 1
#     if max(val) == cnt:
#         ans = 'YES'
#         break
# print(ans)


# k = int(input())
# idx = 1
# for j in range(5, int(k**0.5) + 1):
#     if not k % j:
#         idx = j
#         break
#
# if idx < 5 or k // idx < 5:
#     print('-1')
# else:
#     pattern = 'aeiou' + 'aeiou'[:max(0, idx - 5)]
#     ans = ''
#     for i in range(k // idx):
#         j = i % len(pattern)
#         ans += pattern[j:] + pattern[:j]
#     print(ans)


# n = int(input())
# u = list(map(int, input().split()))
# g, cnt = [0] * 10, 0
# ans = 0
# for i in range(n):
#     g[u[i] - 1] += 1
#     unique = set(g)
#     unique.discard(0)
#     if len(unique) == 1:
#         k = unique.pop()
#         if k == 1:
#             ans = i
#         elif g.count(k) == 1:
#             ans = i
#     elif len(unique) == 2:
#         if 1 in unique and g.count(1) == 1:
#             ans = i
#         else:
#             a, b = unique
#             if a < b:
#                 b, a = a, b
#             if a - b == 1 and g.count(a) == 1:
#                 ans = i
# print(ans + 1)


# m, n = map(int, input().split())
# a = [list(map(int, input().split())) for i in range(m)]
# b = [list(map(int, input().split())) for j in range(m)]
# ans = 'Possible'
# for i in range(m):
#     j = 0
#     a[i][0], b[i][0] = ((a[i][j], b[i][j]), (b[i][j], a[i][j]))[a[i][j] > b[i][j]]
#     if i and (a[i][j] <= a[i - 1][j] or b[i][j] <= b[i - 1][j]):
#         ans = 'Impossible'
#         break
# if ans == 'Possible':
#     for j in range(n):
#         i = 0
#         a[i][j], b[i][j] = ((a[i][j], b[i][j]), (b[i][j], a[i][j]))[a[i][j] > b[i][j]]
#         if j and (a[i][j] <= a[i][j - 1] or b[i][j] <= b[i][j - 1]):
#             ans = 'Impossible'
#             break
#
# if ans == 'Possible':
#     for i in range(1, m):
#         if ans == 'Possible':
#             for j in range(1, n):
#                 a[i][j], b[i][j] = ((a[i][j], b[i][j]), (b[i][j], a[i][j]))[a[i][j] > b[i][j]]
#                 if a[i][j] <= a[i - 1][j] or a[i][j] <= a[i][j - 1]:
#                     ans = 'Impossible'
#                     break
#                 if b[i][j] <= b[i - 1][j] or b[i][j] <= b[i][j - 1]:
#                     ans = 'Impossible'
#                     break
# print(ans)


# n = int(input())
# a = list(map(int, input().split()))
# ans = float('inf')
# for i in range(n):
#     ans = min(ans, a[i] // max(i, n - i - 1))
# print(ans)


# import string
# alpha = string.ascii_lowercase
# for t in range(int(input())):
#     s = input()
#     a = [ord(ch) - ord('a') for ch in s]
#     a.sort()
#     odd, even = [], []
#     for ch in a:
#         if ch % 2:
#             odd.append(ch)
#         else:
#             even.append(ch)
#     if odd and even:
#         b = odd + even if abs(odd[-1] - even[0]) > 1 else even + odd
#     else:
#         b = (odd, even)[not len(odd)]
#     ans = ''
#     for i in range(1, len(b)):
#         if abs(b[i] - b[i - 1]) == 1:
#             ans = 'No answer'
#             break
#     if ans == '':
#         for i in range(len(b)):
#             ans += alpha[b[i]]
#     print(ans)


# n = int(input())
# s = input()
# eight = s.count('8')
# ans = 'YES'
# if (n - 11) // 2 >= eight or eight == 0:
#     ans = 'NO'
# if ans == 'YES':
#     cnt, e, i = 0, 0, 0
#     while e <= (n - 11) // 2:
#         if s[i] == '8':
#             e += 1
#         else:
#             cnt += 1
#         i += 1
#     if cnt > (n - 11) // 2:
#         ans = 'NO'
# print(ans)


# m, n, h = map(int, input().split())
# front = list(map(int, input().split()))  # n
# left = list(map(int, input().split()))  # m
# up = [list(map(int, input().split())) for i in range(m)]
# for i in range(m):
#     for j in range(n):
#         if up[i][j]:
#             up[i][j] = min(left[i], front[j])
# for row in up:
#     print(' '.join((str(i) for i in row)))


# x = int(input())
# c, ans = 0, []
# for i in range(40):
#     if x == (2**len(format(x, 'b')) - 1):
#         break
#     if i % 2:
#         x += 1
#     else:
#         ans.append(len(format(x, 'b')))
#         x = x ^ (2**ans[-1] - 1)
#     c += 1
# print(c)
# if c:
#     print(' '.join((str(i) for i in ans)))


# m, n = map(int, input().split())
# a = [list(map(int, input().split())) for i in range(m)]
# b = a[0][0]
# ans = [1] * m
# for i in range(1, m):
#     b = b ^ a[i][0]
# for i in range(m):
#     for j in range(n):
#         if b ^ a[i][0] ^ a[i][j] != 0:
#             ans[i] = j + 1
#             print('TAK')
#             exit(print(*ans))
#             break
# print('NIE')


# n = int(input())
# a = [list(ch for ch in input()) for i in range(n)]
# for i in range(n - 2):
#     for j in range(n - 2):
#         if a[i][j] == '#':
#             if all(a[I][J] == '.' for I, J in ((i, j + 1),
#                                                (i + 1, j), (i + 1, j + 1), (i + 1, j + 2),
#                                                (i + 2, j + 1))):
#                 for I, J in ((i, j + 1),
#                              (i + 1, j), (i + 1, j + 1), (i + 1, j + 2),
#                              (i + 2, j + 1)):
#                     a[I][J] = '#'
# for i in range(n):
#     for j in range(n):
#         if a[i][j] == '.':
#             exit(print('NO'))
# print('YES')


# n = input()
# i = len(n) - 1
# k = 1
# for t in n:
#     k = k * int(t)
# ans = k
# while i:
#     if n[i] == '0':
#         n = str(int(n[:i + 1]) - 1) + n[i + 1:]
#     elif n[i] != '9':
#         n = str(int(n[:i + 1]) - int(n[i]) - 1) + n[i + 1:]
#     i -= 1
#     k = 1
#     for t in n:
#         k = k * int(t)
#     ans = max(ans, k)
# print(ans)


for t in range(int(input())):
    n = int(input())
    s = input()
    l, r = 0, 0
    if s[0] == '<':
        for i in range(1, n):
            if s[i] != s[i - 1]:
                l = i
                break
    if s[-1] == '>':
        for i in range(n - 2, -1, -1):
            if s[i] != s[i + 1]:
                r = n - i - 1
                break
    print(min(l, r))
