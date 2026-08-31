import sys

lines = sys.stdin.readlines()
password = lines[0]
options = lines[2:]

if password in options:
    print("YES")
else:
    can_first = any(map(lambda s: s[1] is password[0], options))
    can_second = any(map(lambda s: s[0] is password[1], options))
    if can_first and can_second:
        print("YES")
    else:
        print("NO")
