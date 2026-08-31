# -*- coding: utf-8 -*-
"""
Created on Mon Dec 11 14:04:22 2017

@author: ms
"""

def check(playing, win):
    ingame = []
    out = -1
    for i in range(3):
        if playing[i] == True:
            ingame.append(i)
        else:
            out = i
    if win == out: return False
    else: return True
    
def change(playing, win):
    for i in range(3):
        if i == win:
            continue
        else:
            playing[i] = not playing[i]
    return playing

def main():
    n = int(input())
    winners = []
    for i in range(n):
        inp = int(input())
        winners.append(inp)
    
    playing = [True, True, False]
    
    for it in range(n):
        win = winners[it]
        go = check(playing, win-1)
        if (go):
            playing = change(playing, win-1)
        else:
            print("NO")
            return
    print("YES")
    return
main()