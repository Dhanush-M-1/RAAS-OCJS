def dictionary(d, s):
    for i in s:
        if i not in d:
            d[i] = 1
        else:
            d[i] += 1

n = int(input())
s1 = list(input().split())
s2 = list(input().split())
s3 = list(input().split())

d1 = {}; d2 = {}; d3 = {}

dictionary(d1, s1); dictionary(d2, s2); dictionary(d3, s3)

if len(d2) < len(d1):
    print(''.join(set(s1) - set(s2)))
else:
    for i in d2:
        if d2[i] != d1[i]:
            print(i)
            break

if len(d3) < len(d2):
    print(''.join(set(s2) - set(s3)))
else:
    for i in d3:
        if d3[i] != d2[i]:
            print(i)
            break
