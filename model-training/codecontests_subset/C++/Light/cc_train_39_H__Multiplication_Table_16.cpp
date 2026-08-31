#include <bits/stdc++.h>
using namespace std;
int base;
string get(int a) {
  if (a == 0) return "0";
  string res = "";
  for (; a; a /= base) res += char(a % base + '0');
  reverse(res.begin(), res.end());
  return res;
}
int main() {
  scanf("%d", &base);
  for (int i = 1; i < base; i++) {
    for (int j = 1; j < base; j++) cout << get(i * j) << " ";
    cout << endl;
  }
  return 0;
}
