"""
NTC here
"""
from sys import stdin, setrecursionlimit
setrecursionlimit(10**7)


def iin(): return int(stdin.readline())
 
 
def lin(): return list(map(int, stdin.readline().split()))


# range = xrange
# input = raw_input
def main():
    n,p,w,d=lin()
    x,y,z=(p+w-1)//w,0,0
    intr=0
    while p!=(x*w+y*d):
    #    print(x,y)
        if intr>100000:break
        intr+=1
        if (x+y)>n or  x<0 :break
        sl=x*w+y*d
        if sl>p:
            x-=1
            df=p-sl+w
           # print('inner',df,d,p,sl)
            y+=(df+d-1)//d
        else:
            break
    if x<0:print(-1)
    else:
        if (x+y)>n or w*x+y*d!=p:
            print(-1)
        else:
            z=n-x-y
            print(x,y,z)

try:
    main()
except Exception as e: print(e)