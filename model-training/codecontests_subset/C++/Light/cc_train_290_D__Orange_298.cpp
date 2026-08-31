#include <bits/stdc++.h>
using namespace std;
int main() {
  string n;
  int x;
  cin >> n >> x;
  string q = "";
  for (int i = 0; i < n.size(); i++) {
    if (n[i] <= 'Z') n[i] += 32;
    int kk = n[i];
    if (kk < x + 97) {
      q = q + (char)(n[i] - 32);
    } else {
      q = q + n[i];
    }
  }
  cout << q;
}
