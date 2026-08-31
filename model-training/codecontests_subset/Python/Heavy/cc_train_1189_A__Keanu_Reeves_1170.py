x = input()
y = input()


if len(y)% 2 != 0:
    print("1")
    print(y)
elif len(y) % 2 == 0 and len(y) != 2:
    if y.count("0") != y.count("1"):
        print("1")
        print(y)
    else:
        
        t = y[:len(y)//2]
        s = y[len(y)//2 :]
        if (t.count("0") != t.count("1")) and (s.count("0") != s.count("1")):
            print("2")
            print(t + " " + s)
        elif (t.count("0") == t.count("1")) and (s.count("0") == s.count("1")):
            p = y[:len(y)//2 + 1]
            q = y[len(y)//2 + 1:]
            print("2")
            print(p + " " + q) 
elif len(y) == 2:
    if y.count("0") != y.count("1"):
        print("1")
        print(y)
    else:
        print("2")
        a = y[0]
        b = y[1]
        print(a + " " + b)