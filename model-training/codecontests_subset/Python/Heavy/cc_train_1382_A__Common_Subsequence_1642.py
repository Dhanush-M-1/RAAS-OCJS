import random

#FUNGSI BUAT NGECEK ADA ELEMEN SAMA NGGAK
hasil = []

def elemensama(arr1,arr2):
    global hasil
    sama = []
    found = False
    for data1 in arr1:
        for data2 in arr2:
            if data1==data2:
                found = True
                sama += [data1]
    if found == True:
        x = random.choice(sama)
        hasil += ['YES']
        hasil += ['1 '+str(x)]
    else:
        hasil += ['NO']


t = int(input())



for i in range(t):
    len = input().split(' ')
    Tab_a = input().split(' ')
    Tab_b = input().split(' ')

    elemensama(Tab_a,Tab_b)

for row in hasil:
    print(row)