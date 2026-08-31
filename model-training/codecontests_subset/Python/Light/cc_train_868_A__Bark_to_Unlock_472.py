import sys

s = sys.stdin.readline().strip()
n = int(sys.stdin.readline())

def checkPass(s,n):
    words = []
    for t in range(n):
        words.append(str(sys.stdin.readline().strip()))
        if words[-1]==s:
            return 'YES'
    for word1 in range(n):
        for word2 in range(n):
            
            if (words[word1][1]+words[word2][0]==s) or (words[word2][1]+words[word1][0]==s):
                return 'YES'
    return 'NO'

print(checkPass(s,n))