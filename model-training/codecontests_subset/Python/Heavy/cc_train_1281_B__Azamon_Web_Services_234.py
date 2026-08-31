n_cases = int(input())
for _ in range(n_cases):
    s, t = input().split()
    
    if s < t:
        print(s)
        continue
        
    cnt = [0] * 26
    for ch in s:
        cnt[ord(ch) - 65] += 1

    s = list(s)
    for i in range(len(s)):
        ch = ord(s[i]) - 65
        flag = False
        for j in range(ch):
            if cnt[j] > 0:
                s[i] = chr(65 + j)
                cnt[j] -= 1
                flag = True
                break
        if flag:
            # print(cnt)            
            for j in range(i+1, len(s)):
                temp = ord(s[j]) - 65
                if cnt[temp] > 0:
                    cnt[temp] -= 1
                else:
                    s[j] = chr(ch + 65)
            break
        else:
            cnt[ch] -= 1
            
    s = "".join(s)
    if s < t:
      print(s)
    else:
      print("---")