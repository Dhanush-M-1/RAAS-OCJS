n = int(input())
s = input()
if n == 1:
    print('1')
    print(s)
else:
    e, o = 0, 0
    k = 1
    for i in range(n):
        if s[i] == '1':
            e += 1
        else:
            o += 1
    if o != e:
        print(k)
        print(s)
    else:
        x = 0
        k = 2
        while o == e:
            x += 1
            s1 = s[:x]
            e, o = 0, 0
            for i in range(x, n):
                if s[i] == '1':
                    e += 1
                else:
                    o += 1
            if o != e:
                print(k)
                print(s1, s[x:])

            
            
