s = input().split()
plus = 1
minus = 0
for c in s:
	if (c == '+') : 
		plus += 1
	if (c == '-') : 
		minus += 1

n = int(s[len(s) - 1])
mx = plus * n - minus
mn = plus - n * minus
now = n - (plus - minus)

if (n > mx or n < mn): 
    print("Impossible")
    exit()

pre = '+'
print("Possible")
for c in s: 
    if (c == '?'):
        if (pre == '+') :
            val = 1
            if (now > 0) : 
                val = min(n-1, now) + 1   
            now -= val - 1
            print(val, end = ' ')
        if (pre == '-'):
            val = 1
            if (now < 0) : 
                val = min(abs(n)-1, abs(now)) + 1
            now += val - 1
            print(val, end = ' ')
    else :
        print(c, end = ' ')
    pre = c
