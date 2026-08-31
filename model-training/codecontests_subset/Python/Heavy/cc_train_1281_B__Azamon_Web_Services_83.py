# https://codeforces.com/problemset/problem/1281/B

def amazon(s,c):
    if (s < c):
        return (s)
    elif(c=='a'*len(c)):
        return ('---')
    else:
        for j in range(len(s) - 1):
            check = 0
            for k in range(j + 1, len(s)):
                word = s
                # print(f"{j}:{s[j]}\n{k}:{s[k]}")
                if (s[j] > s[k]):
                    word = word[:j] + word[k] + word[j + 1:k] + word[j] + word[k + 1:]
                    # print(word)
                if (word < c):
                    return word
        return ('---')


for i in range(int(input())):
    s, c = input().strip().split()
    print(amazon(s,c))
