def f(x,y):
    if y >= x*2:
        return x*3
    return (y//2)*3

def main():
    import sys,bisect
    input = sys.stdin.readline
    t = int(input())
    for __ in [0]*t:
        a,b,c = map(int,input().split())
        res = 0

        if b >= 2*a:
            res = max(res,3*a+f(b-2*a,c))
        
        if b >= c//2:
            res = max(res,(c//2)*3+f(a,b-c//2))
        
        for k in range(b+1):
            if c >= 2*k:
                res = max(res,3*k+f(a,b-k))
        print(res)
            
            
if __name__ == '__main__':
    main()