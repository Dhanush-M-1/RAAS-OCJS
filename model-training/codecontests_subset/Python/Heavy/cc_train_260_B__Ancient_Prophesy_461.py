years = {"2013", "2014", "2015"}
base = set()
for i in range(1, 29):
    if i < 10:
        base.add("0" + str(i))
    else:
        base.add(str(i))
info1 = base.copy()
info1.add("29")
info1.add("30")
info2 = info1.copy()
info2.add("31")
months = {
    "02": base
}
for i in [4, 6, 9, 11]:
    if i < 10:
        months["0" + str(i)] = info1
    else:
        months[str(i)] = info1
for i in [1, 3, 5, 7, 8, 10, 12]:
    k = ("0" + str(i)) if i < 10 else str(i)
    months[k] = info2

s = input()

def solve(s, years, months):
    maps = {}
    i = 0
    while i < len(s) - 9:
        if s[i+2] != "-" or s[i+5] != "-":
            i += 1
            continue
        d, m, y = s[i:i+2], s[i+3:i+5], s[i+6:i+10]
        if y in years and m in months and d in months[m]:
            k = s[i:i+10]
            maps[k] = maps.get(k, 0) + 1
        i += 1
    ans, count = "", 0
    for k, v in maps.items():
        if count < v:
            ans, count = k, v
    return ans 
    

ans = solve(s, years, months)
print(ans)
    	 		 		   		 				 	   				