t  = int(input());
for test in range(t):
    a,b = map(int,input().split());
    s = input();
    arr = list(map(int,input().split()));
    warr = [[0 for i in range(26)] for i in range(len(s))];
    farr = [0 for i in range(26)];
    warr[0][ord(s[0])-97]=1;
    for i in range(1,len(s)):
        for j in range(26):
            warr[i][j]=warr[i-1][j];
        warr[i][ord(s[i])-97]+=1;
    for i in range(len(arr)):
        tarr = warr[arr[i]-1];
        
        for i in range(26):
            farr[i]+=tarr[i];

    for i in range(26):
        farr[i]+=warr[len(s)-1][i];
    print(*farr)
        
