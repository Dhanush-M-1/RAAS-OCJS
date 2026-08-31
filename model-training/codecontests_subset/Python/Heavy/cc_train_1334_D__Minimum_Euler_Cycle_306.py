import sys
input = sys.stdin.readline
for t in range(int(input())):
    n, l, r = map(int, input().split(" "))
    startSection = 2*(n-1)
    startCount = 1
    while(l>startSection):
        
        startCount = startCount + 1
        if(startCount<n):
            startSection = startSection+2*(n-startCount)
        else:
            startSection = startSection + 1
            #print(startSection)
    
            
    endCount = startCount
    endSection = startSection
    while(r>endSection):
        endCount = endCount + 1
        if(endCount<n):
            endSection = endSection+2*(n-endCount)
        else:
            endSection = endSection + 1
        
    l = l - startSection+2*(n-startCount)-1
    r = r - startSection+2*(n-startCount)
    if(r==0):
        r = r+1
    string = []
    #print(startCount)
    #print(endCount)
    for go in range(startCount, endCount+1):
        for k in range(n-go):
            string.append(go)
            string.append(k+1+go)
    string.append(1)
    ans = list(map(str, string[l:r]))
    print(' '.join(ans))
