#include <bits/stdc++.h>
#define STD /*
from sys import exit as sys_ret
"""****************************
 
   cat /dev/ass > /dev/head
            Ctrl+C
   cat /knowledge > /dev/head
              
                © Jakov Gellert
                        frvr.ru
 
****************************"""
# */ using namespace std; int
 
for _ in range(int(input())):
    flag = 1
    amount = int(input())
    Tplays, Tclears = map(int, input().split())
    if Tclears > Tplays:
        flag = 0
    amount -= 1
    plays, clears = Tplays, Tclears
    while amount != 0:
        amount -= 1
        Tplays, Tclears = map(int, input().split())
        if Tclears > Tplays or Tplays < plays or Tclears < clears or Tplays - plays < Tclears - clears:
            flag = 0
        plays, clears = Tplays, Tclears
    print("YES" if flag == 1 else "NO")