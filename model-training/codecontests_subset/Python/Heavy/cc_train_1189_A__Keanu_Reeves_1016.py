def analiz(st, n):
    k = 0
    for x in st:
        if x == '1':
            k += 1
    if k != n - k:
        stt.append(st)
        return(True)
    else:
        return(False)

def output(stt):
    print(len (stt))
    for i in range(len(stt)):
        print(stt[i], end = ' ')

global stt, n
n = int(input())
st = input()
st1 = st2 = ''
stt = []

if analiz(st, n):
   output(stt)
else:
    st1 = st[0 : (n // 2)]
    dl = len(st1)
    if analiz(st1, dl):
        st2 = st[(n // 2):n]
        #print(st2)
        dl = len(st2)
        analiz(st2, dl)
        output(stt)
    else:
        st1 = st[0: (n // 2 + 1)]
        dl = len(st1)
        if analiz(st1, dl):
            st2 = st[(n // 2 + 1):n]
            dl = len(st2)
            analiz(st2, dl)
            output(stt)