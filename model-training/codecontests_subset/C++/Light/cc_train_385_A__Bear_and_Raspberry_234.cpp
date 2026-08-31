#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    v[i] = a;
  }
  int biggestdif = 0;
  for (int i = 0; i < n - 1; i++) {
    if (v[i] - v[i + 1] > biggestdif) biggestdif = v[i] - v[i + 1];
  }
  cout << max(0, biggestdif - c);
}
