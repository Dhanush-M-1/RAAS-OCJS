k = int(input())
s = input()

t = list(set(s))
freq = [0]*len(t)
rept = [0]*len(t)

for i in range(len(s)):
    for j in range(len(t)):
        if s[i] == t[j]:
            freq[j] += 1

ok = True
#test minimo
if min(freq) < k:
    ok = False
#teste sobras
if ok:
    for i in range(len(freq)):
        resto = freq[i]%k
        if resto != 0:
            ok = False
            break
        rept[i] = freq[i]//k

#casos em que todos são k
if ok:
    saida = ""
    for i in range(len(t)):
        saida += t[i]*rept[i]
    #ajustar vetor freq
    saida *= k
    print(saida)
else:
    print(-1)
