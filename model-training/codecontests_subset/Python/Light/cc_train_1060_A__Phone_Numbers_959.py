n = int(input())
phone = input()
count = 0
for i in range(n):
    if (phone[i] == '8'):
        count += 1
print(int(min(count, n / 11)))
