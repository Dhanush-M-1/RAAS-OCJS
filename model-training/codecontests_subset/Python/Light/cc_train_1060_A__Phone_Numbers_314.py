T=int(input())
N=str(input())
delapan=N.count("8")
jumlah=T//11

if delapan <= jumlah:
    print(delapan)
else:
    print(jumlah)