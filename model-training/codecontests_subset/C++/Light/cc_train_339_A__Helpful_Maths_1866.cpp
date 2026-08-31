#include <bits/stdc++.h>
using namespace std;
template <class T>
const bool is_impar(T x) {
  return (bool)(x & 1);
}
int n;
string s, rez;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> s;
  for (int i = 0; i < ((int)(s).size()); i += (2)) rez += s[i];
  sort(rez.begin(), rez.end());
  cout << rez[0];
  for (int i = 1; i < (int)(rez).size(); i++) cout << '+' << rez[i];
  return 0;
}
