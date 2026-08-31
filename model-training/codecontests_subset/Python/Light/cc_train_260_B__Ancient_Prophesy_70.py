import re
from collections import defaultdict 
s = input()
x = re.findall("(?=(\d\d-\d\d-\d\d\d\d))", s)
month_to_day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
ans = ""
def val():
    return 0
date_count = defaultdict(val)
max_count = 0
for date in x:
    d, m, y = [int(x) for x in date.split('-')]
    if(2013 <= y <= 2015 and 1 <= d <= 31 and 1 <= m <= 12 and 0 < d <= month_to_day[m]):
        date_count[date] += 1
        if date in date_count and date_count[date] > max_count:
            max_count = date_count[date]
            ans = date 
print(ans)