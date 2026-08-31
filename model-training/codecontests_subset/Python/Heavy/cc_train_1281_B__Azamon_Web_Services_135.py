# def compare(a, b):
#     if b.startswith(a) and a != b:
#         return True
#     else:
#         for x, y in zip(a, b):
#             if x == y:
#                 continue
#             elif x < y:
#                 return True
#             else:
#                 return False


def main():
    s, c = input().split()
    # sl = list(s)
    n = len(s)
    if s < c:
        print(s)
        return
    # for i in range(len(s)):
    #     for j in range(len(s)-1, i, -1):
    #         sn = s[:i] + s[j] + s[i+1:j] + s[i] + s[j+1:]
    #         if sn < c:
    #             print(sn)
    #             return
    i = n - 2
    j = n - 1
    while i > -1:
        sn = s[:i] + s[j] + s[i+1:j] + s[i] + s[j+1:]
        # Get the next j value by comparing the character
        # and then the index in the string.
        j = min(i, j, key=lambda x: (s[x], -x))
        if sn < c:
            print(sn)
            return
        i -= 1
    print('---')


t = int(input())
for _ in range(t):
    main()
