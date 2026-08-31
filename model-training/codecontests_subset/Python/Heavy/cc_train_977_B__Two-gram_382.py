n = int(input())
string = input()
a = []
if len(string)==2:
    print(string)
else:
    for x in range(n-1):
        if string[x:x+2] not in a:
            a = a + [string[x:x+2]]
        
    #print(a)
    c = len(a)
    b = []
    for k in range(c):
        b = b + [0]
    for x in range(n):
        i = 0
        while i<c:
            if string[x:x+2] == a[i]:
                b[i] = b[i] + 1
                break
            else:
                i = i+1
    #print(b)
    d = b.index(max(b),0,c)
    print(a[d])

        