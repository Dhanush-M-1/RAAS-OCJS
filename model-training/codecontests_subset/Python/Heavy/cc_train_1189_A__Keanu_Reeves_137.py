n=int(input())
s=str(input())
count_of_ones=s.count('1')
count_of_zeroes=s.count('0')
a=n-1
if s is '1':
    print(len([s]))
    print(s)
elif s.count('1')!=s.count('0'):
    print(len([s]))
    print(s)
else:
    while a != 0:
        substrings = []
        check = []
        for x in range(0, n, a):
            substrings.append(' ' + s[x:x + a])
        for y in range(len(substrings)):
            if substrings[y].count('1') != substrings[y].count('0'):
                pass
            elif substrings[y].count('1') == substrings[y].count('0'):
                check.append(0)
                a -= 1
        if 0 not in check:
            substrings[0] = substrings[0].replace(' ', '')
            print(len(substrings))
            print(''.join(substrings))
            break

        a -= 1