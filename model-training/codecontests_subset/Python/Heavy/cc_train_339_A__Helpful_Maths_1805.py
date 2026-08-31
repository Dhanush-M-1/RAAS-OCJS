#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Rian Mandala Putra
#
# Created:     24/11/2017
# Copyright:   (c) Rian Mandala Putra 2017
# Licence:     <your licence>
#-------------------------------------------------------------------------------

angka=[]
a=input()
for i in range(len(a)):
    if a[i]=='1' or a[i]=='2' or a[i]=='3':
        angka+=[int(a[i])]
for i in range(len(angka)-1):
    for j in range(len(angka)-1):
        if angka[j]>angka[j+1]:
            tem=angka[j]
            angka[j]=angka[j+1]
            angka[j+1]=tem
for i in range(len(angka)):
    print(angka[i],end="")
    if i<len(angka)-1:
        print("+",end="")