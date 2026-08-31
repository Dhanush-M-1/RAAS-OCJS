from sys import stdin, stdout

def main():
    n = int(stdin.readline())
    
    x = [0] * (n+1)
    h = [0] * (n+1)
    
    for i in range(1, n+1):
        xi, hi = map(int, stdin.readline().split())
        
        x[i] = xi
        h[i] = hi
        
    r = [0]* (n+1)
    l = [0]* (n+1)
    p = [0]* (n+1)
    
    for i in range(1, n+1):
        # keep in place always possible
        p[i] = max(r[i-1], l[i-1], p[i-1])
        
        # left falling
        l[i] = -1
        if i == 1:
            l[i] = 1
        else:
            # max of i-1 point and left fall
            if x[i-1] < x[i] - h[i]:
                l[i] = max(l[i-1], p[i-1]) + 1
            if x[i-1] + h[i-1] < x[i] - h[i]:
                l[i] = max(l[i], r[i-1] + 1)
        
        #right falling
        r[i] = -1
        if i == n:
          r[i] = max(r[i-1], l[i-1], p[i-1]) + 1
        else:
            if x[i] + h[i] < x[i+1]:
                r[i] = max(r[i-1], l[i-1], p[i-1]) + 1
    print(max(r[i], l[i], p[i]))
main()
