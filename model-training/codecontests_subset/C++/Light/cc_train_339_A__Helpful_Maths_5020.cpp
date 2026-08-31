#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  string s;
  int one = 0, two = 0, thr = 0, i, n;
  cin >> s;
  for (i = 0; i < s.length(); i = i + 2) {
    if (s[i] == '1') {
      one++;
    } else if (s[i] == '2') {
      two++;
    } else
      thr++;
  }
  n = one + two + thr;
  n--;
  while (one--) {
    printf("1");
    if (n != 0) {
      printf("+");
      n--;
    }
  }
  while (two--) {
    printf("2");
    if (n != 0) {
      printf("+");
      n--;
    }
  }
  while (thr--) {
    printf("3");
    if (n != 0) {
      printf("+");
      n--;
    }
  }
  return 0;
}
