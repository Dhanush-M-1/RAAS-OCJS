#http://codeforces.com/problemset/problem/868/A

#not done

from itertools import permutations

def unlock1(word,substring):
    if len(word) == 1:
        word = word + word
    perms = ["".join(w) for w in permutations(word)]
    for perm in perms:
        end = len(substring)-1
        start = 0
        check = perm[:end+1]
        #print(check)
        while end != len(perm):
            if check == substring:
                return True
            end += 1
            start += 1
            check = perm[start:end+1]
            #print(check)
    return False
        
    print(perms)

def unlock(word,substring):
    if False:
        return
    else:
        for w in word:
            #print(w)
            if w == substring:
                return True
        for i in range(len(word)):
            for j in range(len(word)):
                #print(word[i][1]+word[(j+1)%len(word)][0])
                if word[i][1]+word[(j+1)%len(word)][0] == substring:
                    return True
    return False
#print(unlock(["ah","oy","to","ha"],"ya"))
#print(unlock(["ht","tp"],"hp"))
#print(unlock(["ah"],"ha"))


while True:
    try:
        pw = input()
        count = input()
        words = []
        for i in range(int(count)):
            words.append(input())
        if unlock(words,pw):
            print("YES")
        else:
            print("NO")
    except EOFError:
        break
