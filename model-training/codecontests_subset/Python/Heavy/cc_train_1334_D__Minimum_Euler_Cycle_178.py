from sys import stdin

def allWays(start, verts, done, stack, n):
    global valid
    if not valid:
        return
    stack.append(start)
    if len(done) == len(verts):
        print(stack)
        stack.pop()
        valid = False
        return
    for x in range(1,n+1):
        if start != x and not (start,x) in done:
            done.add((start,x))
            allWays(x,verts,done,stack,n)
            done.remove((start,x))
    stack.pop()
'''
for y in range(1,10):
    verts = set([((x//y) + 1, (x%y)+1) for x in range(y**2)])
    for x in range(1,y+1):
        verts.remove((x,x))
    valid = True
    print(y, end=' ')
    allWays(1, verts, set(), [], y)
'''

def order(n,x):
    out = []
    for y in range(x+1,n+1):
        out.append(x)
        out.append(y)
    return out

for case in range(int(stdin.readline())):
    n,l,r = [int(x) for x in stdin.readline().split()]

    end1 = False

    if r == n*(n-1) + 1:
        end1 = True
        r -= 1

    if l == n*(n-1) + 1:
        print(1)
    

    else:
        x = 1

        while l > 2*(n-x):
            l -= 2*(n-x)
            r -= 2*(n-x)
            x += 1

        out = order(n,x)
        r -= 2*(n-x)
        x += 1

        while r > 0:
            out += order(n,x)
            r -= 2*(n-x)
            x += 1

        if end1:
            out += [1]

        if r != 0:
            realOut = out[l-1:r]
        else:
            realOut = out[l-1:]
        print(' '.join([str(b) for b in realOut]))
            
            

        

    

     
