'''
A string is good when either its first character is > or the last is <. Strings of type < … > are not good,
 as their first and last characters will never change and they will eventually come to the form < >.

So, the answer is the minimum number of characters from the beginning of the string, which must be removed so that
the first symbol becomes >,
or minimum number of characters from the end of the string, which must be removed so that the last symbol becomes <.

'''

for testis in range(int(input())):
    n = int(input())
    s = input()
    ss = s[::-1]
    a = 0
    b = 0
    while s[a]=='<' and a<n-1:
        a = a +1
    while ss[b]=='>' and b<n-1:
        b = b +1
    #print(a,b)
    print(min(a,b))