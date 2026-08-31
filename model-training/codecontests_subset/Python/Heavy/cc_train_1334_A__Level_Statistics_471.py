from sys import stdin, stdout
"""
    n = stdin.readline()
    arr = [int(x) for x in stdin.readline().split()]
    stdout.write(str(summation))
"""
t = int(stdin.readline())
for test in range(t) :
    n = int(stdin.readline())
    arr = [int(x) for x in stdin.readline().split()]
    ans = "YES"
    play = arr[0]
    clear = arr[1]
    if clear>play :
        ans = "NO" 

    for i in range(n-1) :
        arr = [int(x) for x in stdin.readline().split()]
        play2 = arr[0]
        clear2 = arr[1]

        if clear2>play2 or (play2<play) or (clear2<clear) or (play2-play<clear2-clear):
            ans = "NO"
        play = play2
        clear = clear2

    stdout.write(ans+"\n")