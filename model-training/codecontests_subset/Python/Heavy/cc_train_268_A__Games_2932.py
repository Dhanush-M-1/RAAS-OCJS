#include <bits/stdc++.h>
#define SYNC ios_base::sync_with_stdio(0);
#define IO STD std_enable = 1; cin.tie(0);
#define STD /*
from sys import (
stdin, stdout, exit as sys_ret)
"""****************************

       Interactive Tasks:

          / Python: /       """
f_input, f_print, f_flush = (
        stdin.readline,
        stdout.write,
        stdout.flush)

"""        / C++ /
       #import <cstdio>
       fflush(stdout);
             or
       #import <iostream>
       cout << endl;

   —————————————————————————
    Don't raise your voice,
    improve your argument.
   —————————————————————————

   cat /dev/ass > /dev/head
            Ctrl+C
   cat /knowledge > /dev/head

                © Jakov Gellert
                        frvr.ru

****************************"""
# */ using namespace std; int
#define boost_stream(); IO SYNC

amount = int(f_input())
teams = [[int(_) for _ in f_input().split()] for i in range(amount)]
count = 0
for i in range(amount):
    for j in range(amount):
        if i != j and teams[i][0] == teams[j][1]:
            count += 1
f_print(str(count))