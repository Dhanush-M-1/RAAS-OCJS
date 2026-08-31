# n = int(input())
# s = list(input().strip())

# def is_vowel(x):
#     if 'aeiouy'.find(x) == -1:
#         return False
#     return True

# if n > 1:
#     p, q = 0, 1
#     t = list()
#     t.append(s[0])
#     while q < len(s):
#         if is_vowel(s[p]) and is_vowel(s[q]):
#             q += 1
#         else:
#             t.append(s[q])
#             p = q
#             q += 1
#     s = t
# print(''.join(map(str, s)))

n = int(input())
a = list(map(int, input().strip().split()))

res = min(a[-1] - 1, 1000000 - a[0])
for i in range(n-1):
    res = min(res, max(a[i] - 1, 1000000 - a[i+1]))
print(res)