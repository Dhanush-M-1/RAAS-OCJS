n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

# print(a)
# print(b)

a_el_count = {}
b_el_count = {}

for el in a:
	if el in a_el_count:
		a_el_count[el] += 1
	else:
		a_el_count[el] = 1

for el in b:
	if el in b_el_count:
		b_el_count[el] += 1
	else:
		b_el_count[el] = 1

a_count_el = {}
b_count_el = {}

a_unique = list(set(a))
len_a_unique = len(a_unique)

b_unique = list(set(b))
len_b_unique = len(b_unique)

for el in a_unique:
	if a_el_count[el] in a_count_el:
		a_count_el[a_el_count[el]].add(el)
	else:
		a_count_el[a_el_count[el]] = {el}

for el in b_unique:
	if b_el_count[el] in b_count_el:
		b_count_el[b_el_count[el]].add(el)
	else:
		b_count_el[b_el_count[el]] = {el}

# print(a_count_el)
# print(b_count_el)


ans_set = set([ (item + m - a_unique[0]) % m for item in b_count_el[a_el_count[a_unique[0]]]])
for a_el in a_unique:
	# print("ans_set: ", ans_set)
	ans_set = ans_set.intersection( set([ (item - a_el + m) % m for item in b_count_el[a_el_count[a_el]]  ] ) )

print(min(ans_set))

# print("a_el_count:" + str(a_el_count))
# print("b_el_count:" + str(b_el_count))

# count_0 = a_el_count[0]

# el_to_comp_i = 0
# b_cand_i = 0
# b_all_cand = b_count_el[a_el_count[a_unique[0]]]

# while el_to_comp_i < len_a_unique and b_cand_i < len(b_all_cand):
# 	el_to_comp = a_unique[el_to_comp_i]
# 	b_cand = b_all_cand[b_cand_i]
# 	if ((el_to_comp+b_cand) % m) in b_el_count and b_el_count[(el_to_comp+b_cand) % m] == a_el_count[el_to_comp]:
# 		el_to_comp_i += 1
# 	else:
# 		b_cand_i += 1
# 		el_to_comp_i = 0

# print(b_cand)