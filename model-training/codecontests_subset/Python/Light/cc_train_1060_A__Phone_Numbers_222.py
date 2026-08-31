int(input())
s = input()
count = 0
if len(s) < 11 or '8' not in s : print(0)
else:
    for i in s:
        if i == '8': count += 1
        
    while count > 0:
        if (len(s) - count) >= count * 10:
            print(count)
            break
        else: count -= 1
            
