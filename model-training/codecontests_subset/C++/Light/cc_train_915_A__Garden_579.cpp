#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int answer = 1e9;
  int n, k;
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) {
    int a;
    cin >> a;
    if (k % a == 0) {
      answer = min(answer, k / a);
    }
  }
  cout << answer << '\n';
}
