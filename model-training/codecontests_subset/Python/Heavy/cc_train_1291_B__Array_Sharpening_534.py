t  = int(input())
ans = []

def f(ns):
    ok = True
    for i in range(len(ns)):
        if 0 <= i <= int(ns[i]) or len(ns)-int(ns[i])-1 <= i <= len(ns)-1:
            ok = True
        else:
            ok = False
            break
            
    if ok:
        if len(ns) % 2 == 0:
            h = len(ns)//2 
            if int(ns[h-1]) == h-1 and int(ns[h]) == h-1:
                return "No"
            else:
                return "Yes"
        else:
            return "Yes"
    else:
        return "No"



for i in range(t):
    n = int(input())

    s = input()

    ns = s.split()

    ans.append(f(ns))


for e in ans:
    print(e)
