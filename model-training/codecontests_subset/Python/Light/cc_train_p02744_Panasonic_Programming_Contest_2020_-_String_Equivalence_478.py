import string

n = int(input())
s = string.ascii_letters[:n]

ans_list = ['a']
for i in range(n-1):
    ans_list = [ans + c for ans in ans_list for c in s[:len(set(ans)) + 1]]

print(*ans_list, sep='\n')