# https://codeforces.com/problemset/problem/1060/A
n=int(input())
string = input()
string = string.replace('9','0')
arr = sorted(list(string))
i=0
j=n-1
ans=0
while i + 9 < j:
    if arr[j]=='8':
        j-=1
        i+=10
        ans+=1
    else:
        break
print(ans)
