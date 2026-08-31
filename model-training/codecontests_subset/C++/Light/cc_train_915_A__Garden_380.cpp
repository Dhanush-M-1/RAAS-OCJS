#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  int N, K, Min = INT_MAX;
  cin >> N >> K;
  for (int i = 0; i < N; ++i) {
    int A;
    cin >> A;
    if (K % A == 0) Min = min(Min, K / A);
  }
  cout << Min;
  return 0;
}
