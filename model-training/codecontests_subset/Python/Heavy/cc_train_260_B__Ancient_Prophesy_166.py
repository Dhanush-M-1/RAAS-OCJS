try:
    import re

    st = input()

    dct = {}

    r = re.compile(r'(\d\d-\d\d-\d\d\d\d)')
    r2 = re.compile(r'(\d\d)-(\d\d)-(\d\d\d\d)')

    def judge_date(date):
       rst = r2.match(date)
       d, m, y = map(int, rst.groups())
       if 2013 <= y <= 2015:
           if 1 <= m <= 12:
               if m in (1, 3, 5, 7, 8, 10, 12):
                   if d > 31:
                       return False
               elif m == 2:
                   if d > 28:
                       return False
               else:
                   if d > 30:
                       return False
               if d <= 0:
                   return False
               return True
       return False

    while st:
       rst = r.search(st)
       if rst is None:
           break
       awd = rst.group()
       if judge_date(awd):
           try:
               dct[awd] += 1
           except KeyError:
               dct[awd] = 1
       st = st[rst.start() + 1:]

    print(max(dct.items(), key=lambda x: x[1])[0])
except Exception as e:
    print(e)
