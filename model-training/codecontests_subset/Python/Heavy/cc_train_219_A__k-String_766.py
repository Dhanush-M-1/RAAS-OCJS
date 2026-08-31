import string

def is_okay(d, k):
    for v in d.values():
        if v%k != 0:
            return False
    return True

k = int(input())

s = input()

if k == 1:
    print(s)
    exit()

count = {}
for c in s:
    if c not in count:
        count[c] = 1
    else:
        count[c] += 1
nums = list(count.values())

if not is_okay(count, k):
    print('-1')
    exit()

ans = []
for _ in range(k):
    for c in string.ascii_lowercase:
        if c in count:
            ans.append(c*(count[c]//k))

print(''.join(ans))
