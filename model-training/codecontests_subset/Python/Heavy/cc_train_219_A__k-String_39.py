k=int(input())
stri = input()

letters = [ 0 for i in range(97,123) ]
good = True

for i in range(len(stri)):
    letters[ord(stri[i])-97]+=1

for i in range(0,123-97):
    if letters[i]%k!=0:
        good=False

if not good:
    print("-1")
else:
    done=False
    orig = letters[:]
    while not done:
        done=True
        for i in range(0,123-97):
            if letters[i]!=0:
                done=False
                print(chr(i+97)*(int(orig[i]/k)),end="")
                letters[i]-=int(orig[i]/k)
