n = int(input())
s = input()

tot = 0
curI = s.count('I')
curF = s.count('F')
curA = s.count('A')
for i in range(len(s)):
    if(s[i] == 'I'):
        if(curF + curA == len(s)-1):
            tot+=1
    if(s[i] == 'A'):
        if(curF + curA -1 == len(s)-1):
            tot+=1
print(tot)