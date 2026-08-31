s1 = input()
s2 = input()

def split(s1, s2):
    if len(s1) != len(s2):
        return False

    if s1  == s2:
        return True

    if len(s1) % 2 != 0:
        return False

    if len(s1) == 2:
        return (s1[0] == s2[1] and s2[0] == s1[1]) or (s1[0] == s2[0] and s1[1] == s2[1])


    mid = len(s2) // 2
    a1, a2 = s1[:mid], s1[mid:]
    b1, b2 = s2[mid:], s2[:mid]

    return (split(a1, b1) and split(a2, b2)) or (split(a1, b2) and split(a2,b1))


if split(s1, s2):
    print("YES")
else:
    print("NO")
