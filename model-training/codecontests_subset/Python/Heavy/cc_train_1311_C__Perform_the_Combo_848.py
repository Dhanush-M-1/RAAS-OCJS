for _ in range(int(input())):
    d= {'a':0, 'b':0, 'c':0, 'd':0, 'e':0, 'f':0, 'g':0, 'h':0, 'i':0, 'j':0, 'k':0, 'l':0, 'm':0, 'n':0, 'o':0, 'p':0, 'q':0,'r':0, 's':0, 't':0, 'u':0, 'v':0, 'w':0, 'x':0, 'y':0, 'z':0}
    n, m = map(int, input().split())
    s = input()
    arr = sorted(list(map(int, input().split()))) + [n]

    z = 0
    for i in range(n):
        while i > arr[z]-1:
            z = z+1
        d[s[i]] += m -z+ 1

    for i in d:
        if i !='z':
            print(d[i], end=' ')
        else:
            print(d[i])



# for _ in range(int(input())):
# 	z, y = map(int, input().split())
# 	str1 = input()
# 	li = list(map(int, input().split()))
# 	li.sort()
 
# 	li+=[z]
# 	li1 = [0]*26
# 	x = 0	
# 	for i in range(y+1):
# 		a = li[i]
# 		for j in str1[x:a]:
# 			li1[ord(j)-97] += (y-i+1)
# 		x = a
# 	print(*li1)