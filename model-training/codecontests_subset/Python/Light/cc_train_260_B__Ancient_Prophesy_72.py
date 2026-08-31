s = input()
x = s.split('-')
cnt = {}
days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for i in range(2, len(x)):
    day = x[i - 2][-2:]
    month = x[i - 1]
    year = x[i][:4]
    if len(year) == 4 and 2013 <= int(year) <= 2015 and len(day) == 2 and len(month) == 2:
        d = int(day)
        m = int(month)
        if 1 <= m <= 12 and 1 <= d <= days[m - 1]:
            key = '%s-%s-%s' % (day, month, year)
            cnt[key] = cnt.get(key, 0) + 1
m = 0
for key, val in cnt.items():
    if val > m:
        m = val
        res = key
print(res)
