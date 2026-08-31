import re 
s = input()
# print(re.findall("(?=(\d\d\d))", s))
x = re.findall("(?=(\d\d-\d\d-\d\d\d\d))", s)
# print(x)
ans = ""
# print(x)
# input()
# print(x.split('-'))
# input()
date_count = {}
max_count = 0
for date in x:
    d, m, y = [int(x) for x in date.split('-')]
    if(2013 <= y <= 2015 and 1 <= d <= 31 and 1 <= m <= 12):
        if m in [1, 3, 5, 7, 8, 10, 12] and 1 <= d <= 31:
            try:
                date_count[date] += 1
            except KeyError:
                date_count[date] = 1
        elif m == 2 and 1 <= d <= 28:
            try:
                date_count[date] += 1
            except KeyError:
                date_count[date] = 1
        elif m in [4, 6, 9, 11] and 1 <= d <= 30:
            try:
                date_count[date] += 1
            except KeyError:
                date_count[date] = 1 
        if date in date_count and date_count[date] > max_count:
            max_count = date_count[date]
            ans = date 
    else:
        pass

# print(x)
# print(date_count)
print(ans)