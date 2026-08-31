a, b, c = input(), input(), input()

all_set = set(a + b + c)

a_dict = {ch : a.count(ch) for ch in all_set}
b_dict = {ch : b.count(ch) for ch in all_set}
c_dict = {ch : c.count(ch) for ch in all_set}

bMin = min([a_dict[ch] // b_dict[ch] for ch in all_set if b_dict[ch] > 0])
bsum, csum = 0, 0
for i in range(bMin + 1):
    j = min((a_dict[ch] - b_dict[ch] * i) // c_dict[ch] for ch in all_set if c_dict[ch] > 0)
    if i + j > bsum + csum:
        bsum, csum = i, j
print(b * bsum, end = "")
print(c * csum, end = "")
for ch in all_set:
    print(ch * (a_dict[ch] - b_dict[ch] * bsum - c_dict[ch] * csum), end = '')
print()