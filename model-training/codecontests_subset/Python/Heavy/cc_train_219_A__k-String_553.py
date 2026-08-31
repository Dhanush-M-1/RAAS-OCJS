k = int(input())
word = input()
n_word = ''
out = []
for i in range(len(word)):
    if word[i] not in n_word :
        n_word += word[i]
#print(n_word)
can = True

for j in range(0,len(n_word)):
    if word.count(n_word[j]) % k != 0  :
        #print(n_word[j])
        can = False
        break
if can == False :
    print('-1')
else:
    for b in range(len(n_word)):
        out.append(n_word[b])
    out.sort()
    out_str = ''
    for a in range(len(out)):
        out_str += out[a] * (word.count(out[a]) // k)
    output = out_str * k
    print(output)
