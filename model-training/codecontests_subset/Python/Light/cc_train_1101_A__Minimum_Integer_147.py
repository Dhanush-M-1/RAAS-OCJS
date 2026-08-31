import math
import os
import random
import re
import sys
from collections import Counter
a=[]
l=[]
n=int(input())
for i in range(n):
	l+=[list(map(int,input().split()))]

for i in range(n):
	if  l[i][2]<=l[i][1] and l[i][2]>=l[i][0]:
		print(l[i][2]*((l[i][1]//l[i][2])+1))
	else:
		print(l[i][2])