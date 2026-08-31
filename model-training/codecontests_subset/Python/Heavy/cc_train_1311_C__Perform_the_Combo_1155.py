t = int(input())

for T in range(t):
    n,m = list(map(int,input().split()))
    s = input()
    charsright = list(map(int,input().split()))

    char_dict = dict()
    test_list = []
    alpha = 'a'
    for i in range(0, 26): 
        test_list.append(alpha) 
        alpha = chr(ord(alpha) + 1)

    for i in test_list:
        char_dict[i] = [0]*n
    
    count_dict = dict()
    
    for i in test_list:
        count_dict[i] = 0
    
    for i in range(len(s)):
        count_dict[s[i]] += 1
        char_dict[s[i]][i] = count_dict[s[i]]
        for j in test_list :
            if j!= s[i] and i>0:
                char_dict[j][i] = char_dict[j][i-1]
    
    # print(count_dict)  


    ans_dict = dict()
    for i in test_list:
        ans_dict[i] = 0
    # print(char_dict)
    for i in range(m):
        index = charsright[i]-1
        for j in range(26):
            ans_dict[test_list[j]] += char_dict[test_list[j]][index]
    

            
    # print(ans_dict)
     
    for i in range(len(s)):
        ans_dict[s[i]] += 1
    
    ans = []
    for i in ans_dict:
        ans.append(ans_dict[i])
    
    print(*ans)