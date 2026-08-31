n = int(input())
inp = input()

a = list(map(int, inp.split()))

odd_a = list()
ndd_a = list()

for x in a:
    if x % 2 == 0:
        odd_a.append(x)
    else:
        ndd_a.append(x)

sum_1 = 0
sum_2 = 0

odd_a = sorted(odd_a)
ndd_a = sorted(ndd_a)

odd_a_r = odd_a.copy()
ndd_a_r = ndd_a.copy()

cur = True

while len(odd_a) > 0 and len(ndd_a) > 0:
    if cur:
        odd_a.pop()
    else:
        ndd_a.pop()
    cur = not cur
if cur and len(odd_a) > 0:
    odd_a.pop()
if (not cur) and len(ndd_a) > 0:
    ndd_a.pop()
    
sum_1 = sum(odd_a) + sum(ndd_a)

cur = False

while len(odd_a_r) > 0 and len(ndd_a_r) > 0:
    if cur:
        odd_a_r.pop()
    else:
        ndd_a_r.pop()
    cur = not cur
if cur and len(odd_a_r) > 0:
    odd_a_r.pop()
if (not cur) and len(ndd_a_r) > 0:
    ndd_a_r.pop()

sum_2 = sum(odd_a_r) + sum(ndd_a_r)

print(min(sum_1, sum_2))
