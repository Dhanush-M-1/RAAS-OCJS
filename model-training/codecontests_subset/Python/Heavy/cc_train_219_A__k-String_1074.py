'''
INPUT SHORTCUTS
N, K = map(int,input().split())
N ,A,B = map(int,input().split())
string = str(input())
arr = list(map(int,input().split()))
N = int(input())
'''


def main(K,string):
	dp = [0 for _ in range(26)]
	for i in range(len(string)):
		dp[ord(string[i])-ord('a')]+=1
	res = ''
	for i in range(26):
		if dp[i]!=0:
			if dp[i]%K!=0:
				print(-1)
				return 
			else:
				res+= (chr(ord('a')+i)*(dp[i]//K))
	print(res*(K))


def text():
	with open("input.txt","r") as f:
		t = int(f.readline().rstrip())
		while t:
			N = int(f.readline().rstrip())
			string = str(f.readline().rstrip())
			string = list(string)
			main(N,string)
			t-=1

def normal():
	N = int(input())
	string =str(input())
	string = list(string)
	main(N,string)



# text()

normal()

