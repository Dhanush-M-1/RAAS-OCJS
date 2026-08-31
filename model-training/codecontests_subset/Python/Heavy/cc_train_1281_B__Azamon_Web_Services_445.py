def main():
	t = int(input())
	for n in range(t):
		(s, c) = (x for x in input().split())
		print(solver(s, c))

def solver(s, c):
	if s < c:
		return s
	else:
		smallestLetter = 'z'
		smallestLetterIndex = None
		swapLeft = None
		swapRight = None
		for i in range(len(s) - 1, 0, -1):
			if s[i] < smallestLetter:
				smallestLetter = s[i]
				smallestLetterIndex = i
			if s[i - 1] > smallestLetter:
				swapLeft = i - 1 
				swapRight = smallestLetterIndex
		if swapLeft != None:
			newS = s[:swapLeft] + s[swapRight] + s[swapLeft + 1: swapRight] + s[swapLeft] + s[swapRight + 1:]
		else:
			newS = s
		if newS < c:
			return newS
		else:
			return "---"

#print(solver("AZAMON", "APPLE"))
#print(solver("AZAMON", "AAAAA"))
#print(solver('OS', 'KSK'))
main()
