def pair(s):
    count = 0
    wordCount = []
    WORD = ''
    word = []
    for i in range(len(s)-1):
        WORD = s[i:i+2]
        for j in range(len(s)-1):
            if s[i:i+2] == s[j:j+2]:
                # print(s[i:i+2], s[j:j+2])
                count += 1
        word.append(WORD)
        wordCount.append(count)
        count = 0
    
    m = max(wordCount)
    ind = wordCount.index(m)
    return word[ind]
        


if __name__ == "__main__":
    n = input().strip()
    st = input().strip()
    print(pair(st))