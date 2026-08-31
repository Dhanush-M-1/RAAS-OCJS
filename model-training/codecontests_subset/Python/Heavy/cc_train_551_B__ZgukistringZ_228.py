import string
from collections import defaultdict
INF = 2147483647

string_a = input()
string_b = input()
string_c = input()

dict_a = defaultdict(int)
dict_b = defaultdict(int)
dict_c = defaultdict(int)

for ch in string_a:
    dict_a[ch] += 1
for ch in string_b:
    dict_b[ch] += 1
for ch in string_c:
    dict_c[ch] += 1

bn, cn = 0, 0
for i in range(100001):
    j = INF
    for ch in string.ascii_lowercase:
        a, b, c = dict_a[ch], dict_b[ch], dict_c[ch]
        a -= b*i
        if a < 0:
            j = -1
        if c != 0:
            j = min(j, int(a/c) )
    if j == -1:
        break
    if i+j > bn+cn:
        (bn, cn) = (i, j)

res = ""
for i in range(bn):
    res += string_b
for i in range(cn):
    res += string_c

for ch in string.ascii_lowercase:
    a, b, c = dict_a[ch], dict_b[ch], dict_c[ch]
    a -= b*bn + c*cn
    res += ch*a

print(res)

