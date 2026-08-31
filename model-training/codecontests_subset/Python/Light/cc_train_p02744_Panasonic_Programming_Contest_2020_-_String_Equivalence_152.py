def d(s,n):
 if len(s)==n:return print(s)
 for i in range(97,ord(max(s))+2):d(s+chr(i),n)
d("a",int(input()))