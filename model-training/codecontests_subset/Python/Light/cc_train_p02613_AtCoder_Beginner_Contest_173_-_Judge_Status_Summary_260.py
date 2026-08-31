s = open(0).read().count
for r in "AC", "WA", "TLE", "RE":
    print(r, "x", s(r))