n=int(input())
a_list=[int(a) for a in input().split()]
b_list=[int(b) for b in input().split()]+[10**9+1]
c_list=[int(c) for c in input().split()]+[10**9+1]+[10**9+2]
a_list.sort()
b_list.sort()
c_list.sort()
for i in range(n):
    if a_list[i]!=b_list[i]:
        print(a_list[i])
        break
for i in range(n):
    if b_list[i]!=c_list[i]:
        print(b_list[i])
        break
