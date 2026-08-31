import sys,math
input=sys.stdin.readline
t=int(input())
def f(d):
    for i in range(26):
        if chr(97+i) not in d:
            return chr(97+i)
for tttt in range(t):
    s = input().strip("\n")
    n = len(s)
    l = []
    for i in s:
        l.append(i)
    for i in range(1,n):
        if l[i] == l[i-1] or (i-2>=0 and l[i] == l[i-2]):
            d = {l[i]:1}
            if i-2>=0:
                d[l[i-2]] = 1
            if i + 1 < n:
                try:
                    d[l[i+1]] += 1
                except:
                    d[l[i+1]] = 1
            if i + 2 < n:
                try:
                    d[l[i+2]] += 1
                except:
                    d[l[i+2]] = 1
            l[i] = f(d)
                
    count = 0
    for i in range(n):
        if l[i] != s[i]:
            count += 1
    print(count)
