n = int( input().strip() )
a = list( map( int, input().strip().split(' ') ) )
b = list( map( int, input().strip().split(' ') ) )
c = list( map( int, input().strip().split(' ') ) )
a.sort()
b.sort()
c.sort()
ans = a[len(a)-1]
for i in range( len(b) ):
    if a[i] != b[i]:
        ans = a[i]
        break
print( ans )
ans = b[len(b)-1]
for i in range( len(c) ):
    if b[i] != c[i]:
        ans = b[i]
        break
print( ans )
