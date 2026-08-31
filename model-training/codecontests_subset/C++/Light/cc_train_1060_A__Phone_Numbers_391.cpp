#include <bits/stdc++.h>
using namespace std;
int freq[10];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  string x;
  cin >> n >> x;
  for (int i = 0; i < n; i++) {
    freq[x[i] - '0']++;
  }
  cout << min(n / 11, freq[8]) << '\n';
  return 0;
}
