import sys
input()
d={k:0 for k in 'AC WA TLE RE'.split()}
for ln in sys.stdin:
    d[ln.strip()]+=1
for k,v in d.items():
    print(k,'x',v)
