n = int(input())
odd = list(map(int,input().split()))
even = []
oddnew = []
oddlen = len(odd)
for i in range(oddlen):
    if odd[-1]%2 == 0:
        even.append(odd.pop())
    else:
        oddnew.append(odd.pop())
odd = sorted(oddnew)
even = sorted(even)
oddlen = len(oddnew)
evenlen = len(even)
diff = abs(oddlen - evenlen)
if diff == 1 or diff == 0:
    print(0)
else:
    if oddlen>evenlen:
        oddlen -= 1
        print(sum(odd[:oddlen-evenlen]))
    else:
        evenlen -= 1
        print(sum(even[:evenlen-oddlen]))