n = int(input())
s = input().split()
A = [int(i) for i in s]

num_odd = []
num_even = []
len_odd = 0
len_even = 0

for i in A:
    if i % 2 == 0:
        num_even.append(i)
        len_even += 1
    else:
        num_odd.append(i)
        len_odd += 1
num_odd.sort(reverse=True)
num_even.sort(reverse=True)

if len_odd == len_even:
    print(0)
if len_odd > len_even:
    print(sum(A) - sum(num_even) - sum(num_odd[:len_even + 1]))
if len_odd < len_even:
    print(sum(A) - sum(num_odd) - sum(num_even[:len_odd + 1]))
