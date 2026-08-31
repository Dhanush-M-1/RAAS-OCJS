n=int(input())
s=input()[:n]


l=len(s)
i=0
cnt=0
gram=''

# impo as re
def occurrences(string, sub):
    count = start = 0
    while True:
        start = string.find(sub, start) + 1
        if start > 0:
            count+=1
        else:
            return count
# def count_overlapping(text, search_for):
#     return len(re.findall(search_for, text, overlapped=True))
            
while True:
    
    if(i==l-1):
        break
    gram=s[i]+s[i+1]
    c=occurrences(s,gram)
    
    if(c>cnt):
        cnt=c
        new_gram=gram
    i=i+1
    




print(new_gram)
