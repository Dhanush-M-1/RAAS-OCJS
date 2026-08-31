#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000;
int N, C, data[MAXN];
int main() {
  cin >> N >> C;
  for (int i = 0; i < N; i++) {
    cin >> data[i];
  }
  int ans = 0;
  for (int i = 0; i < N - 1; i++) {
    if (data[i] - data[i + 1] - C > ans) {
      ans = data[i] - data[i + 1] - C;
    }
  }
  cout << ans << endl;
  return 0;
}
