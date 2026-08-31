def parse_arr():
    return list(map(int, input().split(' ')))

n = int(input())
arr = parse_arr()

even = odd = 0
e = []
o = []
for num in arr:
    if num % 2 == 0:
        even += 1
        e.append(num)
    else:
        odd += 1
        o.append(num)

e = sorted(e)
o = sorted(o)

ans = 0

if even == odd or even + 1 == odd or odd + 1 == even:
    print(0)
    exit(0)

# start with even
mini = min(even, odd)

# remaining
e_ = max(even - mini, 0)
o_ = max(odd - mini, 0)

if e_ > 0:
    e_ -= 1

tmp = 0

for num in e:
    if e_ == 0:
        break
    else:
        tmp += num
        e_ -= 1

for num in o:
    if o_ == 0:
        break
    else:
        tmp += num
        o_ -= 1

ans = tmp

# reverse the effect
# remaining
e_ = max(even - mini, 0)
o_ = max(odd - mini, 0)

if o_ > 0:
    o_ -= 1

tmp = 0

for num in e:
    if e_ == 0:
        break
    else:
        tmp += num
        e_ -= 1

for num in o:
    if o_ == 0:
        break
    else:
        tmp += num
        o_ -= 1



if tmp < ans:
    ans = tmp

print(ans)