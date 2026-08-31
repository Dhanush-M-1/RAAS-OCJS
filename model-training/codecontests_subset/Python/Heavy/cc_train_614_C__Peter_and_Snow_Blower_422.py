#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from sys import stdin
from collections import defaultdict
from operator import itemgetter
from math import hypot, pi, sqrt

def main():
  n, cx, cy = tuple(map(int, stdin.readline().split()))
  ps = [tuple(map(int, stdin.readline().split())) for _ in range(n)]
  print("{0:.10f}".format( run(n, (cx, cy), ps) ))

def run(n, cnt, ps):
  ps.append(ps[0])
  mx = max([pdist(cnt, p) for p in ps])
  mn = min([dist(cnt, ps[i], ps[i+1]) for i in range(n)])
  return pi * (mx + mn) * (mx - mn)

def pdist(p1, p2):
  return hypot(p2[0] - p1[0], p2[1] - p1[1])

def dist(cnt, p1, p2):
  dx = p2[0] - p1[0]
  dy = p2[1] - p1[1]
  t = ((cnt[0] - p1[0]) * dx + (cnt[1] - p1[1]) * dy) / (dx * dx + dy * dy)
  if t < 0:
    return pdist(cnt, p1)
  elif t > 1:
    return pdist(cnt, p2)
  else:
    p = (p1[0] + t * dx, p1[1] + t * dy)
    return pdist(cnt, p)

if __name__=="__main__":
   main()
