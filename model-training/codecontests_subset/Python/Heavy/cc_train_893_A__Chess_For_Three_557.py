n = int( input() )

ALEX = 0
BOB = 1
CARL = 2

ingame = [1,1,0]

def out( tmp ):

    global ingame

    for j in range( len(ingame) ):
        if tmp != j:
            ingame[j] = 1 - ingame[j]

for i in range( n ):
    x = int( input() )

    #print( "before" )
    #print( ingame )
    if x == 1:
        if ingame[ALEX]:
            out( ALEX )
        else:
            print( "NO" )
            exit(0)

    if x == 2:
        if ingame[BOB]:
            out( BOB )
        else:
            print( "NO" )
            exit(0)

    if x == 3:
        if ingame[CARL]:
            out( CARL )
        else:
            print( "NO" )
            exit(0)

    #print( "after")
    #print( ingame )

print( "YES" )
