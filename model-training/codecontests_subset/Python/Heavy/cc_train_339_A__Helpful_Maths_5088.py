# vowels = ["a", "o", "y", "e", "u", "i"]
# s = list(input().lower())
# ans = ""
# for i in vowels:
#     if i in s:
#         while i in s:
#             s.remove(i)
# for i in range(len(s)):
#     s[i] = "." + s[i]
# print(ans.join(s))


# n = int(input())
# ans = 0
# for i in range(n):
#
#     s = input()
#     if "-" in s:
#         ans -= 1
#     if "+" in s:
#         ans += 1
#
#
# print(ans)

# s1 = input().lower()
# s2 = input().lower()
# isequal = False
# for i in range(len(s1)):
#     if s1[i] > s2[i]:
#         print("1")
#         isequal = True
#         break
#     if s2[i] > s1[i]:
#         print("-1")
#         isequal = True
#         break
# if not isequal:
#     print("0")

# s = list(input())
# not_dangerous = False
# for i in range(len(s)):
#     if i != len(s) - 1:
#         j = 0
#         while i + j <= len(s) - 1 and s[i] == s[i + j]:
#             j += 1
#         if j >= 7:
#             print("YES")
#             not_dangerous = True
#             break
# if not not_dangerous:
#     print("NO")


s = list(input())
ans = ""
while "+" in s:
    s.remove("+")
s.sort()
for i in range(len(s)):
    if i != len(s) - 1:
        ans += s[i] + "+"
    else:
        ans += s[i]

print(ans)