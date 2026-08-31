def main():
	n = int(input())
	s = input()
	print(solver(s))


def solver(s):
	eights = s.count('8')
	return min(len(s) // 11, eights)

#print(solver('00000000008'))
#print(solver('0011223344556677889988'))
#print(solver('31415926535'))
main()