a=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
cases=int(input())
while cases > 0:
	cases -= 1
	n,m=map(int,input().split())
	combo=input()
	mis=list(map(int,input().split()))
	mis.sort()
	alpha={}
	freq={}
	for i in range(n+1):
		freq[i]=0
	for mistake in mis:
		freq[mistake]+=1
	for letter in a:
		alpha[letter]=0
	value=1
	index=n-1
	while index >= 0:
		value+=freq[index + 1]
		alpha[combo[index]] += value
		index -= 1
	answer=""
	for letter in a:
		answer += str(alpha[letter])
		answer += ' '
	print(answer)