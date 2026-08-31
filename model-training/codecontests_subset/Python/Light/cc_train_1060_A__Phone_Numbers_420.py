#http://codeforces.com/problemset/problem/1060/A
#8 is chosen at least once and doesn't count
from collections import Counter
n = int(input())
string = input()
counter = Counter(string)
limit = min(int(len(string)/11), counter["8"])
print(limit)
