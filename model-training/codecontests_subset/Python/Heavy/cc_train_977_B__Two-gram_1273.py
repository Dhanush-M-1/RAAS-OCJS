#Codeforces Problem: Codeforces Round #479 (Div. 3) Problem B Two-gram
#Anuraag Lakkaraju

#-----------------------------------------------------------------------
"""
Problem:
Two-gram is an ordered pair (i.e. string of length two) of capital Latin letters. For example, "AZ", "AA", "ZA" — three distinct two-grams.

You are given a string s consisting of n capital Latin letters. Your task is to find any two-gram contained in the given string as a substring (i.e. two consecutive characters of the string) maximal number of times. For example, for string s = "BBAABBBA" the answer is two-gram "BB", which contained in s three times. In other words, find any most frequent two-gram.

Note that occurrences of the two-gram can overlap with each other.

Input
The first line of the input contains integer number n (2≤n≤100) — the length of string s. The second line of the input contains the string s consisting of n capital Latin letters.

Output
Print the only line containing exactly two capital Latin letters — any two-gram contained in the given string s as a substring (i.e. two consecutive characters of the string) maximal number of times.
"""
#---------------------------------Solution---------------------------------------


#Input n and string, which correspond to string lenght and the given string
n = int(input())
s= input()

#f is the list of all possible two grams from "string"
f = []

#converting string to a list of letters from the given string
s = list(s)
#print(s)

#Filling f with the two grams from string
for i in range(0,len(s)-1):
    k = s[i] + s[i+1]
    f.append(k)
#print(f)

#counting the number of two grams and putting them in a list f_count
f_count = []
for j in range(0,len(f)):
    count = 0
    for k in range(0,len(f)):
        if f[j] == f[k]:
            count += 1
        else:
            continue
    f_count.append(count)
#print(f_count)
#Prints the Maximum repeating Two-Gram
print(f[f_count.index(max(f_count))])

