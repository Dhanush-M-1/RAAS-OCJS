'''
//  
//  
//  
//  
//  
//  519B-codeforces.c
//  Bang Bang Bang
//
//  Created by Mohammad Shamim on 11/5/17.
//  Copyright (c) 2017 Mohammad Shamim. All rights reserved. :p
//
'''
n=int(input())
x=[]
c=1
x.append(sorted(list(map(int,input().split(' ')))))
for i in range(1,3,1):
    x.append(sorted(list(map(int,input().split(' ')))))
    m=len(x[i])
    for j in range(m):
        if x[i-1][j]!=x[i][j]:
            print(x[i-1][j])
            c=0
            break
    if c:
        print(x[i-1][m])
    c=1