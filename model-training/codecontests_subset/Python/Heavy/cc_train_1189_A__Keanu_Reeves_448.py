n = int(input())
s = input()
def is_ok(s1,s2):
    z1,o1 = 0,0
    for ch in s1:
        if ch=='1':
            o1+=1
        else:
            z1+=1
    if z1 == o1:
        return False
    z2,o2 = 0,0
    for ch in s2:
        if ch=='1':
            o2+=1
        else:
            z2+=1
    if z2==o2:
        return False
    return True

if n%2 != 0:
    print(1)
    print(s)

elif n == 2:
    if s[1] == s[0]:
        print(1)
        print(s)
    else:
        print(2)
        print(s[0],end=" ")
        print(s[1], end="")
        print("\n",end="")
else:
    z1,o1 = 0,0
    for ch in s:
        if ch=='1':
            o1+=1
        else:
            z1+=1
    if z1 != o1:
        print(1)
        print(s)
    else:
        mid = n//2
        s1 = s[:mid]
        s2 = s[mid:]
        if is_ok(s1,s2) == False:
            s1 = s[:mid-1]
            s2 = s[mid-1:]
        print(2)
        print(s1,end=" ")
        print(s2,end="")
        print("\n",end="")