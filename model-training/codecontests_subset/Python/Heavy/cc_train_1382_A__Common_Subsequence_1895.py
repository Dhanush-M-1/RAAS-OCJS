
for i in range(int(input())):
    n,m = map(int, input().split())
    a = list(set(map(int, input().split())))
    b = list(set(map(int, input().split())))
    a.sort()        
    b.sort()
    an = ""
    num = "oops"
    if min(a) > max(b) or min(b)>max(a):
        an = "NO"
    elif len(a) < len(b): 
        for i in a:
            if i in b:
                num = i
                an = "YES"
                break
            else:
                an = "NO"
    else:
        for i in b:
            if i in a:
                num = i
                an = "YES"
                break
            else:
                an = "NO"
    if an == "YES":
        print(an)
        print(1,num)
    else:
        print(an)