#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  int s1 = 0, s2 = 0, s3 = 0;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    s1 += x;
  }
  for (int i = 0; i < n - 1; ++i) {
    int x;
    cin >> x;
    s2 += x;
  }
  for (int i = 0; i < n - 2; ++i) {
    int x;
    cin >> x;
    s3 += x;
  }
  cout << (s1 - s2) << "\n";
  cout << (s2 - s3) << "\n";
  return 0;
}
