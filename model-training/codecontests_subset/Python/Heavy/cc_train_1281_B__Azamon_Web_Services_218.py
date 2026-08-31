# A brute force implementation
queries = int(input())
for i in range(queries):
    S,C = input().split()
    s = list(S)
    interim = 0
    if S < C:
        print(S)
    else:
        Ssize =len(S)
        pick = sorted(S)
        # Genertaing the smallest possible string with one swap
        for i in range(Ssize):
            if S[i] != pick[i]:
                interim = pick[i];
                break
        # Finding the farthest index 
        for k in range(Ssize-1,-1,-1):
            if S[k] == interim:
                s[k] = s[i]
                s[i] = interim
                break
        result = ''.join(s)
        print (result if result<C else '---')
           