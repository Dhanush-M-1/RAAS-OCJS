#include <bits/stdc++.h>
using namespace std;
int m, n;
int a, b, c;
int main() {
  while (scanf("%d%d%d", &a, &b, &c) != EOF) {
    int ha = a * c;
    int ha1 = b * c;
    int ha2 = (ha - ha1) / b;
    if ((ha - ha1) % b != 0) ha2++;
    cout << ha2 << endl;
  }
  return 0;
}
