import sys,os,io
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline    

def fun(x,y,n):
    if x<0 or y<0:
        return
    if x+y<=n:
        print(x,y,n-x-y)
        exit()

n,p,w,d = [int(i) for i in input().split()]
cnt = p//w
curr = (cnt)*w
if curr == p:
    fun(cnt,0,n)
mwd = w%d
rem = p-curr
if rem%d==0:
    fun(cnt,rem//d,n)
req = (d-rem)%d
if mwd == req:
    fun(cnt-1,(rem+w)//d,n)
curr = (w+w)%d
i = 1
for j in range (10**6):
    i += 1
    if i>cnt:
        break
    curr = (i*w)%d
    if curr == req:
        fun(cnt-i,(rem+i*w)//d,n)
print(-1)