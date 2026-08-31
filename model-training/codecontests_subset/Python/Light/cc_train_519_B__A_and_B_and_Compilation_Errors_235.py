from collections import Counter

n = int(input())

out = []
errors = Counter(input().split())
k = Counter(input().split())


for error in errors:
    if error not in k:
        out.append(error)
        errors = k
        break
    elif errors[error] > k[error]:
        out.append(error)
        errors = k
        break

k = Counter(input().split())


for error in errors:
    if error not in k:
        out.append(error)
        errors = k
        break
    elif errors[error] > k[error]:
        out.append(error)
        errors = k
        break

for x in out:
    print(x)
