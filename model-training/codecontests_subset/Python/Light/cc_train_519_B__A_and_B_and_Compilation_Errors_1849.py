elem = int(input())
s = {}
for i in input().split(' '):
    if i in s:
        s[i] = s[i] + 1
    else:
        s[i] = 1
news = {}
for i in input().split(' '):
    if i in news:
        news[i] = news[i] + 1
    else:
        news[i] = 1
    s[i] = s[i] - 1
    if s[i] == 0:
        del s[i]
for i in input().split(' '):
    news[i] = news[i] - 1
    if news[i] == 0:
        del news[i]
for i in s:
    print(i)
for i in news:
    print(i)