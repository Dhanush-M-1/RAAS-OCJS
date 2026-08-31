from sys import stdin

x = [x.rstrip() for x in stdin]
del x[0]

for i in x[1::2]:
    new = list(map(int, i.split(" ")))

    if len(new) <= 1:
        print("Yes")
    else:
        c = 0
        while c < len(new) and new[c] >= c:
            c += 1

        if c == len(new):
            print("Yes")
        else:
            prev = new[c-1]
            
            while c < len(new) and prev != 0:
                if new[c] < prev:
                    prev = new[c]
                else:
                    prev -= 1

                c += 1

            if c >= len(new):
                print("Yes")
            else:
                print("No")
        
