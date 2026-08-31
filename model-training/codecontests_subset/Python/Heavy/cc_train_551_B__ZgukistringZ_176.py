a = input()
b = input()
c = input()

all_set = set(a + b + c)

def getMin(object_dict, sub_dict):
	return min([object_dict[ch] // sub_dict[ch] for ch in sub_dict.keys() if sub_dict[ch] > 0])

a_dict = {ch : a.count(ch) for ch in all_set}
b_dict = {ch : b.count(ch) for ch in all_set}
c_dict = {ch : c.count(ch) for ch in all_set}

bMin = getMin(a_dict, b_dict)
bsum = 0
csum = 0
for i in range(bMin + 1):
	j = min((a_dict[ch] - b_dict[ch] * i) // c_dict[ch] for ch in all_set if c_dict[ch] > 0)
	if i + j > bsum + csum:
		bsum, csum = i, j
print(b * bsum, end = "")
print(c * csum, end = "")

for ch in all_set:
	print(ch * (a_dict[ch] - b_dict[ch] * bsum - c_dict[ch] * csum), end = '')
print()