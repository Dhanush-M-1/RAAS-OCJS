def isg(a):
    return a == 'a' or a == 'e' or a == 'i' or a == 'o' or a == 'u' or a == 'y'


n = int(input())
s = input()
curr = ''
k = 1
for i in range(n):
    if isg(s[i]):
        if s[i] == curr:
            k += 1
        else:
            if (curr != 'o' and curr != 'e') or k != 2:
                print(curr, end='')
            else:
                print(curr + curr, end='')
            k = 1
            curr = s[i]
    else:
        if (curr != 'o' and curr != 'e') or k != 2:
            print(curr, end='')
        else:
            print(curr + curr, end='')
        curr = ''
        k = 1
        print(s[i], end='')
if (curr != 'o' and curr != 'e') or k != 2:
    print(curr, end='')
else:
    print(curr + curr, end='')
