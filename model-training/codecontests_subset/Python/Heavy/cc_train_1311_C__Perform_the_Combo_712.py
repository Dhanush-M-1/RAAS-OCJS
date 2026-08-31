t = int(input())
for i in range(t):
    n, m = input().split()
    m = int(m)
    n = int(n)
    s = input()
    p = list(map(int, input().split()))
    
    ans = {"a": 0}
    abjad = "bcdefghijklmnopqrstuvwxyz"
    for letter in abjad:
        ans[letter] = 0
    
    number = [0] * n
    for pmem in p:
        number[pmem - 1] += 1
    number[-1] = 1
    
    number_sum = sum(number)
    
    for index in range(n):
        ans[s[index]] += number_sum
        number_sum -= number[index]
    
    abjad = "a" + abjad
    answer = []
    for letter in abjad:
        answer.append(ans[letter])
    
    answer = list(map(str, answer))
    print(" ".join(answer))