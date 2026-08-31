n=int(input())

def f(idx, mx, str):
    # print(idx, mx, str)
    if idx==n:
        print(str)
        return
    for i in range(mx+1+1):
        f(idx+1, max(i, mx), str+chr(ord('a')+i))

f(0,-1,"")
