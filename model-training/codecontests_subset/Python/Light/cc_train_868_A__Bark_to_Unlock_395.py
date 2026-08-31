s = input()

n = int(input())
a = []
ans_1 = False
ans_2 = False
total_ans = False

for _ in range(n):
    st = input()
    if st[::-1] == s or s == st:
        total_ans = True
        break
    if st[0] == s[1]:
        ans_1 = True
    if st[1] == s[0]:
        ans_2 = True

if ans_1*ans_2 or total_ans:
    print("YES")
else:
    print("NO")
