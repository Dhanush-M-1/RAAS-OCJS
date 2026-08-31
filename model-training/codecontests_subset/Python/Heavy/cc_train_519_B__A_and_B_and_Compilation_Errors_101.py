n=int(input())
a=list(map(int, input().split()))
a.sort()
b=list(map(int, input().split()))
b.sort()
ai = 0
bi = 0
first = None
while ai < len(a) and bi < len(b):
    if a[ai] == b[bi]:
        ai+=1
        bi+=1
    else:
        #they differ. Found missing
        first = a[ai]
        break
if first is None:
    first = a[-1]
print(first)
del a
c=list(map(int, input().split()))
c.sort()
ci = 0
bi = 0
sec = None
while bi < len(b) and ci < len(c):
    if b[bi] == c[ci]:
        #increase both
        bi+=1
        ci+=1
    else:
        #they differ. Found missing
        sec = b[bi]
        break
if sec is None:
    #it was the last one
    sec = b[-1]
print(sec)
