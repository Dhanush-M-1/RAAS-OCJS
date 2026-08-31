candl, new_candl = map(int, input().split())
result = candl
bad_candls = candl
candl = 0
while True:
    if bad_candls % new_candl == 0:
        candl = int(bad_candls / new_candl)
        bad_candls = 0
    else:
        candl = int(bad_candls / new_candl)
        bad_candls = bad_candls % new_candl
    result += candl
    bad_candls += candl
    candl = 0
    if bad_candls < new_candl:
        break
print(result)
