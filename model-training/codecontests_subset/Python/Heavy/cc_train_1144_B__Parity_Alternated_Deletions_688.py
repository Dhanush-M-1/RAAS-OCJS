def count_odd_and_even(lst):
	odd = []
	even = []

	for i in lst:
		if i % 2 == 0:
			even.append(i)
		else:
			odd.append(i)

	odd_num = len(odd)
	even_num = len(even)

	if odd_num == even_num or odd_num + 1 == even_num or even_num + 1 == odd_num:
		return 0

	else:
		delta = abs(odd_num - even_num) - 1

		if odd_num > even_num:
			return sum(odd[:delta])

		elif odd_num < even_num:
			return sum(even[:delta])

n = int(input())
lst = sorted(list(map(int, input().split())))

print(count_odd_and_even(lst))