n = int(input())
s = list(input())
if n%2 == 1:
    print("1")
    print(''.join(s))
else:
    cnt_1 = s.count('1')
    cnt_0 = s.count('0')
    if cnt_0 == cnt_1:
        l = s[0:n//2]
        if l.count('1') == l.count('0'):
            print("2")
            l1 = s[0:n//2+1]
            l2 = s[n//2+1:n]
            print(''.join(l1) + " " + ''.join(l2))
        else:
            print("2")
            l1 = s[0:n//2]
            l2 = s[n//2:n]
            print(''.join(l1) + " " + ''.join(l2))
    else:
        print("1")
        print(''.join(s))