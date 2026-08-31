/*  -*- coding: utf-8 -*-
 *
 * 2874.cc: Pigeonhole principle
 */

#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<cmath>
#include<iostream>
#include<string>
#include<vector>
#include<map>
#include<set>
#include<stack>
#include<list>
#include<queue>
#include<deque>
#include<algorithm>
#include<numeric>
#include<utility>
#include<complex>
#include<functional>
 
using namespace std;

/* constant */

const int MAX_N = 1000;

/* typedef */

/* global variables */

int as[MAX_N];

/* subroutines */

/* main */

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", as + i);

  for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++)
      if (abs(as[j] - as[i]) % (n - 1) == 0) {
	printf("%d %d\n", as[i], as[j]);
	return 0;
      }
  return 0;
}

