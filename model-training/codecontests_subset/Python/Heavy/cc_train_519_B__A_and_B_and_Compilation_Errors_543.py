# Finding compications errors.
# 
# 
# 
# 
# 
# By Petr Kuznetsov

from collections import Counter

def nonzero(seq):
  return [item for item in seq if seq[item]!=0]

def main():
	number_of_errors = int(input())

	first_line = map(int, input().split())
	second_line = map(int, input().split())
	third_line = map(int, input().split())

	first_line = Counter(list(first_line))
	second_line = Counter(list(second_line))
	third_line = Counter(list(third_line))

	first_line.subtract(second_line)
	second_line.subtract(third_line)
	
	print(nonzero(first_line)[0], nonzero(second_line)[0], sep='\n')

	# print({key: value for (key, value) in first_line})


if __name__ == "__main__":
	main()
