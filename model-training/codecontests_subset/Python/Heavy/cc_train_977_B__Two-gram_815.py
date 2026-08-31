# -*- coding: utf-8 -*-
"""
Created on Mon Jul 22 16:52:29 2019

@author: cvela

EXECUTE
######################################
python contest_4.py < input.txt
######################################
"""


import sys
import os

t=sys.stdin.readline()
n_stud=int(t)
t=sys.stdin.readline()

dict_two_grams={}
id_max=-1
max_o=0
for idx in range(len(t)-1):
    two_gram=t[idx:idx+2]
    if two_gram in dict_two_grams.keys():
        dict_two_grams[two_gram]+=1
    else:
        dict_two_grams[two_gram]=1
        
    if dict_two_grams[two_gram]>max_o:
#        print(two_gram, max_o)
        id_max=two_gram
        max_o=dict_two_grams[two_gram]
#print(dict_two_grams)
print(id_max)


##INPUT
##5 10
##10 20 50 60 65
#t=sys.stdin.readline()
#vals=t.split()
#soldiers=int(vals[0])
#d=int(vals[1])
#
#t=sys.stdin.readline()
#heigths=t.split()
#
#dict_height={}
#for height in heigths:
#    if height in dict_height.keys():
#        dict_height[int(height)]+=1
#    else:
#        dict_height[int(height)]=1
#
#lista_keys=list(dict_height.keys())
#lista_keys.sort()
#total_ways=0
#prev_height=-1e10
#prev_2_height=-1e10
#prev_val=0
#prev_2_val=0
#for idx, key in enumerate(lista_keys):
#    search_list=lista_keys[idx+1:]
#    
#        
#        
#    
#print(dict_height)