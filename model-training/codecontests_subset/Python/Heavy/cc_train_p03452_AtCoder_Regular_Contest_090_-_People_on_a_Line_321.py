from collections import deque

n,m = map(int, input().split())
edges = [{} for i in range(n+1)]

for i in range(m):
    l, r, d = map(int, input().split())
    edges[l][r] = d
    edges[r][l] = d * -1

remains = set(range(1,n+1))
deq = deque()

min_ = -1 * 10**10
xs = [min_] * (n+1)

while( len(remains) > 0):
    deq.append( remains.pop() )
    while(len(deq) > 0):
        tmp = deq.popleft()
        if(xs[tmp]  == min_):
            xs[tmp] = 0
        tmp_x = xs[tmp]

        edge = edges[tmp]

        for key,val in edge.items():
            if(xs[key] == min_):
                xs[key] = tmp_x + val
                deq.append( key )
                remains.remove( key )
            else:
                if( xs[key] != tmp_x + val ):
                    print('No')
                    exit()

print('Yes')
