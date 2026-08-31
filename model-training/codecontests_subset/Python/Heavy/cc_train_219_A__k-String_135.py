# Lang: pypy3.6-v7.1.0-win32\pypy3.exe
# Problem Name: K-String
# Problem Serial No: 219
# Problem Type: A
# Problem Url: https://codeforces.com/problemset/problem/219/A 
# Solution Generated at: 2019-11-19 09:47:48.474985 UTC

i = int
cin = input
le = len
s = str

from collections import Counter
k = i(cin())
string = cin()

if k == 1:
    print(string)
else:
    data = Counter(string)
    potential = ''
    for key in data:
        if data[key] % k != 0:
            print(-1)
            exit()
        else:
            res = data[key] // k
            potential += key * res
    print(potential * k)