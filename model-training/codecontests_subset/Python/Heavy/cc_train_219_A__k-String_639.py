k = input()
k = int(k)
s = input()
#create a histogram
counts = dict()
i = 0
while True:
    counts[s[i]] = counts.get(s[i], 0) + 1
    i+=1
    if i >= len(s):
        break
i = 0
sub = ''
for key,value in counts.items():
    if value%k != 0:
        print("-1")
        i = 1
        break
if i == 0:
    for key, value in counts.items():
        value = value/k
        i = 0
        while i < value:
            i+=1
            sub = sub + key
    newsub = ''
    i = 0
    while i < k:
        newsub = newsub + sub
        i += 1
    print(newsub)
