n, k = [int(i) for i in input().split()]
a_likes = list()
b_likes = list()
both_like = list()
a_likes.append(0)
b_likes.append(0)
both_like.append(0)
for book in range(n):
    t, a, b = [int(i) for i in input().split()]
    if a == 1 and b == 1:
        both_like.append(t)
    elif a == 1:
        a_likes.append(t)
    elif b == 1:
        b_likes.append(t)
a_likes.sort()
b_likes.sort()
both_like.sort()

for i in range(1, len(a_likes)):
    a_likes[i] += a_likes[i - 1]
for i in range(1, len(b_likes)):
    b_likes[i] += b_likes[i - 1]
for i in range(1, len(both_like)):
    both_like[i] += both_like[i - 1]

if (len(both_like) + len(a_likes)) < k or (len(both_like) + len(b_likes)) < k:
    print('-1')
else:
    # rbo = min(len(both_like) - 1, k - 1)
    # ra = k - rbo - 2
    # rb = k - rbo - 2
    ans = 2 * pow(10, 9) + 1
    rbo = 0
    while rbo < min(len(both_like), k + 1):
        if k - rbo < len(a_likes) and k - rbo < len(b_likes):
            ans = min(ans, both_like[rbo] + a_likes[k - rbo] + b_likes[k - rbo])
        rbo += 1
    if ans < 2 * pow(10, 9) + 1:
        print(ans)
    else:
        print('-1')