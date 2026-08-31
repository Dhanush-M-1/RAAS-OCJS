li="abcdefghijklmn"
n=int(input())
def f(s,l,k):
    global li,n
    if l==n:print(s);return
    for i in range(2+k):
        f(s+li[i],l+1,max(i,k))


f("a",1,0)