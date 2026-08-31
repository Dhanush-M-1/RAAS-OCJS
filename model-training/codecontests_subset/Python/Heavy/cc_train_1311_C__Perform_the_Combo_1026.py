import sys

t = int(sys.stdin.readline())

for query in range(t):
    pressed = {chr(code):0 for code in range(ord('a'),ord('z')+1)}
    n,m = map(int,sys.stdin.readline().strip().split())
    s = sys.stdin.readline().strip()
    p = [int(x) for x in sys.stdin.readline().strip().split()]
    p.sort()
    addTimes = m
    for pos in range(n):
        while addTimes > 0 and p[m-addTimes] <= pos: # 1 < 0
            addTimes -= 1
        #print(addTimes)
        pressed[s[pos]] += (addTimes+1)
    '''
    for sym in s:
        pressed[sym] += 1
    '''
    print(" ".join([str(pressed[sym]) for sym in pressed]))
        
