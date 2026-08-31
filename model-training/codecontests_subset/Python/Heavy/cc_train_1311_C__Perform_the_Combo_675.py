
#create a string in which no two same  char comes together.
# assumption only small albhabetical letters used
#input format: just enter the string without any space
import sys
input = sys.stdin.readline
 
############ ---- Input Functions ---- #######Start#####
def inp():
	return(int(input()))
def inlt():
	return(list(map(int,input().split())))
def insr():
	s = input()
	return(list(s[:len(s) - 1]))
def invr():
	return(map(int,input().split()))

 ############ ---- Input Functions ---- #######End#####   
def pr_list(a):
	print(*a, sep=" ")
	return
def main():
	t = inp()
	for ti in range(t):
		[n,m] =  inlt()
		in_str = insr()
		#print(in_str)
		p = inlt()
		p.sort()
		out = [0 for i in range(26)]
		j = 0
		itr = 0
		while(j<len(p)):
			end = p[j]
			for i in range(itr,end):
				#print(ord(in_str[i]) - ord('a'))
				out[ord(in_str[i]) - ord('a')] = out[ord(in_str[i]) - ord('a')] + len(p) - j
			itr = end
			j = j +1
		for i in in_str:
			out[ord(i) - ord('a')] = out[ord(i) - ord('a')] + 1

		pr_list(out)
	return




	#time o(2n) space o(26*2)

	#sorted(hashm.items(), key=lambda item: item[1])

if __name__== "__main__":
  main()