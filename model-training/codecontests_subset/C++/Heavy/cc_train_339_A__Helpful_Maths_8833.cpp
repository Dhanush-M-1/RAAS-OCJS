#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int k1 = 0, k2 = 0, k3 = 0;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == 49) k1++;
    if (s[i] == 50) k2++;
    if (s[i] == 51) k3++;
  }
  if (k1 == 1 && k2 == 0 && k3 == 0) {
    cout << 1;
    return 0;
  }
  if (k1 == 0 && k2 == 1 && k3 == 0) {
    cout << 2;
    return 0;
  }
  if (k1 == 0 && k2 == 0 && k3 == 1) {
    cout << 3;
    return 0;
  }
  int kn1 = k1, kn2 = k2, kn3 = k3;
  while (k1 > 0) {
    if (kn1 == 1) {
      cout << 1;
      break;
    }
    if (k1 == 1) {
      cout << 1;
      break;
    }
    cout << 1 << "+";
    k1--;
  }
  while (k2 > 0) {
    if (kn1 == 0) {
      cout << 2;
      kn1++;
      k2--;
      continue;
    }
    if (kn2 == 1) {
      cout << "+2";
      break;
    }
    if (k2 == 1) {
      cout << "+2";
      break;
    }
    cout << "+" << 2;
    k2--;
  }
  while (k3 > 0) {
    if (kn1 == 0 && kn2 == 0) {
      cout << 3;
      kn1++;
      kn2++;
      k3--;
      continue;
    }
    if (kn3 == 1) {
      cout << "+3";
      break;
    }
    if (k3 == 1) {
      cout << "+3";
      break;
    }
    cout << "+" << 3;
    k3--;
  }
  return 0;
}
