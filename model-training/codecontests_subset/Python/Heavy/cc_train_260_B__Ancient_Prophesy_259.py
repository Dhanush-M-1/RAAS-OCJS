import re
from collections import defaultdict 
s = input()
x = re.findall("(?=(\d\d-\d\d-\d\d\d\d))", s)
ans = ""
def val():
    return 0
date_count = defaultdict(val)
max_count = 0
for date in x:
    d, m, y = [int(x) for x in date.split('-')]
    if(2013 <= y <= 2015 and 1 <= d <= 31 and 1 <= m <= 12):
        if m in [1, 3, 5, 7, 8, 10, 12] and 1 <= d <= 31:
            date_count[date] += 1
        elif m == 2 and 1 <= d <= 28:
            date_count[date] += 1
        elif m in [4, 6, 9, 11] and 1 <= d <= 30:
            date_count[date] += 1
        if date in date_count and date_count[date] > max_count:
            max_count = date_count[date]
            ans = date 
    else:
        pass

# print(x)
# print(date_count)
print(ans)