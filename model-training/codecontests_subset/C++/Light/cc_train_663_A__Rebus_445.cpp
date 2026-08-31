#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int a, b, n;
vector<char> v;
int main() {
  int i, j, k, l;
  scanf("%*s");
  a++;
  while (1) {
    char s[20];
    scanf("%s", s);
    if (s[0] == '=') {
      scanf("%d", &n);
      break;
    }
    scanf("%*s");
    if (s[0] == '+')
      a++;
    else
      b++;
    v.push_back(s[0]);
  }
  if (n >= a - b * n && n <= a * n - b) {
    printf("Possible\n");
    vector<int> A, B;
    A.resize(a), B.resize(b);
    for (auto &e : A) e = n;
    for (auto &e : B) e = 1;
    int dif = a * n - b - n;
    for (auto &e : A) {
      if (dif >= n - 1)
        dif -= n - 1, e = 1;
      else
        e -= dif, dif = 0;
    }
    for (auto &e : B) {
      if (dif >= n - 1)
        dif -= n - 1, e = n;
      else
        e += dif, dif = 0;
    }
    printf("%d ", A.back());
    A.pop_back();
    for (auto e : v) {
      if (e == '+') {
        printf("+ %d ", A.back());
        A.pop_back();
      } else {
        printf("- %d ", B.back());
        B.pop_back();
      }
    }
    printf("= %d", n);
  } else
    printf("Impossible");
  return 0;
}
