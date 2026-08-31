import sys

def main():
    for ln in sys.stdin:
        s=ln.strip()
        for x in solve(s):
            print(x)

def solve(s):
    b=k=0
    for c in s:
        if c=='(':
            b+=1
        elif c==')':
            b-=1
        else:
            k+=1
            b-=1
        if b<0:
            return [-1]
    bb=0
    for c in reversed(s):
        if c=='(':
            bb-=1
        elif c==')':
            bb+=1
        else:
            break
        if bb<0:
            return [-1]
    ans=[1]*k
    ans[-1]+=b
    return ans

#print(solve('#'))
#print(solve('(#)'))
#print(solve('((#)'))
#print(solve('(((#)((#)'))
#print(solve('()((#((#(#()'))
#print(solve('((((#((#())'))
#print(solve('(((((#'))
#print(solve('##((((((()'))
#print(solve('((#)('))

main()
