n = int(input())
string = input()

cnt = 0
for c in string:
    if c == "8":
        cnt += 1

print(min(cnt, n // 11))
