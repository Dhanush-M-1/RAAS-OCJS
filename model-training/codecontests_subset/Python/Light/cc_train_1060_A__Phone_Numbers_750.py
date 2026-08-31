n = int(input())
s = input()
n8 = 0
for x in range(0,len(s),+1):
    if s[x]=='8':
        n8+=1
    if n8*10+n8>=n:
        break
n-=n8
wyn = int(n/10)
print(min(wyn,n8))